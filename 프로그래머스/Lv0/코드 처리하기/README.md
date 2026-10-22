# [Lv0] 코드 처리하기

- 유형: 구현
- 푼 날짜: 2026-10-22
- 언어: Java

---

### 문제 요약



### 접근 방법

- 



### 막혔던 점 / 배운 점

- 



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
