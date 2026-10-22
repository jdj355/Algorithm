# [Lv0] 코드 처리하기

- 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/181932
- 유형: 구현
- 푼 날짜: 2026-10-22
- 언어: Java

---

### 문제 요약

문자열 `code`가 주어집니다.

`code`를 앞에서부터 읽으면서 만약 문자가 "1"이면 `mode`를 바꿉니다. `mode`에 따라 `code`를 읽어가면서 문자열 `ret`을 만들어냅니다.

`mode`는 0과 1이 있으며, `idx`를 0 부터 `code의 길이 - 1` 까지 1씩 키워나가면서 `code[idx]`의 값에 따라 다음과 같이 행동합니다.

- `mode`가 0일 때
  - `code[idx]`가 "1"이 아니면 `idx`가 짝수일 때만 `ret`의 맨 뒤에 `code[idx]`를 추가합니다.

  - `code[idx]`가 "1"이면 `mode`를 0에서 1로 바꿉니다.


- `mode`가 1일 때
  - `code[idx]`가 "1"이 아니면 `idx`가 홀수일 때만 `ret`의 맨 뒤에 `code[idx]`를 추가합니다.

  - `code[idx]`가 "1"이면 `mode`를 1에서 0으로 바꿉니다.


문자열 `code`를 통해 만들어진 문자열 `ret`를 return 하는 solution 함수를 완성

단, 시작할 때 `mode`는 0이며, return 하려는 `ret`가 만약 빈 문자열이라면 대신 "EMPTY"를 return

### 접근 방법

- mode 값에 따라 0과 1로 값을 나눈다.

- mode==0일때, .if문으로 code[idx] 가 ‘1’일때, 짝수일때  조건으로 값을 추가하고, ‘1’이 아닐때 mode=1로 변경

- mode==1일때, if문으로 code[idx] 가 ‘1’일때, 홀수일때  조건으로 값을 추가하고, ‘1’이 아닐때 mode=0로 변경

- 추가한 값의 길이가 0일때, “EMPTY” return

### 막혔던 점 / 배운 점

- 마지막 sb.length()==0에 조건을 code.length()로 잘못 작성함.



### 코드/

```java


class Solution {
	public String solution(String code) {
		// 1. mode가 0일때
		// code[idx]가 "1"이 아니면 idx가 짝수일 때만 ret의 맨 뒤에 code[idx]를 추가
		// code[idx]가 "1"이면 mode를 0에서 1로 바꿉니다.

		// 2. mode가 1일때
		// code[idx]가 "1"이 아니면 idx가 홀수일 때만 ret의 맨 뒤에 code[idx]를 추가
		// code[idx]가 "1"이면 mode를 1에서 0으로 바꿉니다.
		int mode = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < code.length(); i++) {
			if (mode == 0) {
				if (code.charAt(i) != '1') {
					if (i % 2 == 0) {
						sb.append(code.charAt(i));
					}
				} else {
					mode = 1;
				}
			}else if(mode ==1) {
				if(code.charAt(i)!='1') {
					if(i % 2 !=0) {
						sb.append(code.charAt(i));
					}
				}else if(code.charAt(i)=='1') {
					mode = 0;
				}
			}
			
		}
		if(sb.length()==0) {
			return "EMPTY";
		}

		return sb.toString();

	}
}

```
