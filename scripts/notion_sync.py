"""
Notion '풀이 기록' 데이터베이스 → GitHub 자동 업로드 스크립트

동작
1. 상태가 '업로드 대기'인 페이지를 찾는다.
2. 페이지 본문의 마지막 코드 블록을 Solution.java / solution.py 로,
   페이지 전체(풀이 과정)를 README.md 로 저장한다.
3. 문제별로 git commit 하고 마지막에 push 한다.
4. 노션 페이지 상태를 '업로드 완료'로 바꾸고 GitHub 링크를 채운다.
   (실패 시 '업로드 실패')

필요한 환경변수
- NOTION_TOKEN        : 노션 integration 시크릿
- NOTION_DATABASE_ID  : '풀이 기록' 데이터베이스 ID
- GITHUB_REPOSITORY   : owner/repo (GitHub Actions가 자동으로 넣어줌)
- TARGET_BRANCH       : 기본 main
- BASE_DIR            : 저장소 안 상위 폴더 이름, 기본 '프로그래머스'
"""

import os
import re
import subprocess
import sys
from pathlib import Path
from urllib.parse import quote

import requests

NOTION_TOKEN = os.environ["NOTION_TOKEN"]
DATABASE_ID = os.environ["NOTION_DATABASE_ID"]
REPO = os.environ.get("GITHUB_REPOSITORY", "")
BRANCH = os.environ.get("TARGET_BRANCH", "main")
BASE_DIR = os.environ.get("BASE_DIR", "프로그래머스")

API = "https://api.notion.com/v1"
HEADERS = {
    "Authorization": f"Bearer {NOTION_TOKEN}",
    "Notion-Version": "2022-06-28",
    "Content-Type": "application/json",
}

STATUS_PROP = "상태"
READY = "업로드 대기"
DONE = "업로드 완료"
FAILED = "업로드 실패"

EXT = {"java": ("Solution.java", "java"), "python": ("solution.py", "python")}


# ---------------------------------------------------------------- Notion API
def notion(method, path, **kwargs):
    r = requests.request(method, f"{API}{path}", headers=HEADERS, timeout=30, **kwargs)
    if r.status_code >= 400:
        raise RuntimeError(f"Notion API {r.status_code}: {r.text}")
    return r.json()


def query_ready_pages():
    body = {"filter": {"property": STATUS_PROP, "select": {"equals": READY}}}
    pages, cursor = [], None
    while True:
        if cursor:
            body["start_cursor"] = cursor
        data = notion("POST", f"/databases/{DATABASE_ID}/query", json=body)
        pages += data["results"]
        if not data.get("has_more"):
            return pages
        cursor = data["next_cursor"]


def get_children(block_id):
    blocks, cursor = [], None
    while True:
        params = {"page_size": 100}
        if cursor:
            params["start_cursor"] = cursor
        data = notion("GET", f"/blocks/{block_id}/children", params=params)
        for b in data["results"]:
            if b.get("has_children") and b["type"] not in ("child_page", "child_database"):
                b["_children"] = get_children(b["id"])
            blocks.append(b)
        if not data.get("has_more"):
            return blocks
        cursor = data["next_cursor"]


def update_page(page_id, status, github_url=None):
    props = {STATUS_PROP: {"select": {"name": status}}}
    if github_url:
        props["GitHub"] = {"url": github_url}
    notion("PATCH", f"/pages/{page_id}", json={"properties": props})


# ---------------------------------------------------------------- 속성 읽기
def prop_text(page, name):
    p = page["properties"].get(name)
    if not p:
        return ""
    t = p["type"]
    if t in ("title", "rich_text"):
        return "".join(x["plain_text"] for x in p[t]).strip()
    if t == "select":
        return (p["select"] or {}).get("name", "")
    if t == "multi_select":
        return ", ".join(o["name"] for o in p["multi_select"])
    if t == "url":
        return p["url"] or ""
    if t == "date":
        return (p["date"] or {}).get("start", "")
    return ""


# ---------------------------------------------------------------- 블록 → 마크다운
def rich(rt):
    out = []
    for x in rt:
        s = x["plain_text"]
        a = x.get("annotations", {})
        if a.get("code"):
            s = f"`{s}`"
        if a.get("bold"):
            s = f"**{s}**"
        if a.get("italic"):
            s = f"*{s}*"
        if a.get("strikethrough"):
            s = f"~~{s}~~"
        if x.get("href"):
            s = f"[{s}]({x['href']})"
        out.append(s)
    return "".join(out)


def blocks_to_md(blocks, indent=0):
    lines, pad, num = [], "  " * indent, 0
    for b in blocks:
        t = b["type"]
        d = b.get(t, {})
        num = num + 1 if t == "numbered_list_item" else 0
        if t == "paragraph":
            lines.append(pad + rich(d["rich_text"]))
        elif t in ("heading_1", "heading_2", "heading_3"):
            lines.append("#" * (int(t[-1]) + 1) + " " + rich(d["rich_text"]))
        elif t == "bulleted_list_item":
            lines.append(f"{pad}- {rich(d['rich_text'])}")
        elif t == "numbered_list_item":
            lines.append(f"{pad}{num}. {rich(d['rich_text'])}")
        elif t == "to_do":
            lines.append(f"{pad}- [{'x' if d.get('checked') else ' '}] {rich(d['rich_text'])}")
        elif t == "quote":
            lines.append(f"{pad}> {rich(d['rich_text'])}")
        elif t == "callout":
            icon = (d.get("icon") or {}).get("emoji", "💡")
            lines.append(f"{pad}> {icon} {rich(d['rich_text'])}")
        elif t == "code":
            code = "".join(x["plain_text"] for x in d["rich_text"])
            lines.append(f"{pad}```{d.get('language', '')}\n{code}\n{pad}```")
        elif t == "divider":
            lines.append("---")
        elif t == "equation":
            lines.append(f"$$\n{d.get('expression', '')}\n$$")
        elif t == "image":
            src = d.get("external", {}).get("url") or d.get("file", {}).get("url", "")
            lines.append(f"![image]({src})")
        elif t == "toggle":
            lines.append(f"{pad}<details><summary>{rich(d['rich_text'])}</summary>\n")
        if "_children" in b:
            lines.append(blocks_to_md(b["_children"], indent + 1))
        if t == "toggle":
            lines.append(f"{pad}</details>")
        lines.append("")
    return "\n".join(lines).rstrip() + "\n"


def find_code_blocks(blocks):
    found = []
    for b in blocks:
        if b["type"] == "code":
            found.append(b["code"])
        if "_children" in b:
            found += find_code_blocks(b["_children"])
    return found


# ---------------------------------------------------------------- 파일/깃
def safe_name(s):
    s = re.sub(r"^\[.*?\]\s*", "", s)          # '[예시] ' 같은 접두어 제거
    s = re.sub(r'[\\/:*?"<>|]', "", s).strip()
    return re.sub(r"\s+", " ", s) or "untitled"


def git(*args):
    subprocess.run(["git", *args], check=True)


def process(page):
    title = prop_text(page, "문제")
    level = prop_text(page, "난이도") or "기타"
    lang_prop = prop_text(page, "언어").lower()
    link = prop_text(page, "문제 링크")
    tags = prop_text(page, "유형")
    date = prop_text(page, "푼 날짜")

    blocks = get_children(page["id"])
    codes = find_code_blocks(blocks)
    if not codes:
        raise RuntimeError("코드 블록이 없습니다")

    code_block = codes[-1]  # 마지막 코드 블록 = 최종 제출 코드
    lang = lang_prop or code_block.get("language", "java")
    if lang not in EXT:
        lang = "java" if "java" in code_block.get("language", "") else "python"
    filename, _ = EXT[lang]
    code = "".join(x["plain_text"] for x in code_block["rich_text"]).rstrip() + "\n"

    m = re.search(r"lessons/(\d+)", link)
    folder_name = f"{m.group(1)}. {safe_name(title)}" if m else safe_name(title)
    folder = Path(BASE_DIR) / level / folder_name
    folder.mkdir(parents=True, exist_ok=True)

    header = [f"# [{level}] {safe_name(title)}", ""]
    if link:
        header.append(f"- 문제 링크: {link}")
    if tags:
        header.append(f"- 유형: {tags}")
    if date:
        header.append(f"- 푼 날짜: {date}")
    header.append(f"- 언어: {lang.capitalize()}")
    readme = "\n".join(header) + "\n\n---\n\n" + blocks_to_md(blocks)

    (folder / filename).write_text(code, encoding="utf-8")
    (folder / "README.md").write_text(readme, encoding="utf-8")

    git("add", str(folder))
    staged = subprocess.run(["git", "diff", "--cached", "--quiet"]).returncode != 0
    if staged:
        num = f" - {m.group(1)}" if m else ""
        git("commit", "-m", f"[{level}] {safe_name(title)}{num}")

    url = f"https://github.com/{REPO}/tree/{BRANCH}/" + quote(folder.as_posix())
    return url


def main():
    pages = query_ready_pages()
    print(f"업로드 대기 {len(pages)}건")
    if not pages:
        return

    results = []
    for page in pages:
        title = prop_text(page, "문제")
        try:
            url = process(page)
            results.append((page["id"], url))
            print(f"  ✓ {title}")
        except Exception as e:  # noqa: BLE001
            print(f"  ✗ {title}: {e}", file=sys.stderr)
            update_page(page["id"], FAILED)

    if results:
        git("push", "origin", f"HEAD:{BRANCH}")
        for page_id, url in results:
            update_page(page_id, DONE, url)


if __name__ == "__main__":
    main()
