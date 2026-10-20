# [Lv0] 두 수의 연산값 비교하기

- 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/181938
- 유형: 구현
- 푼 날짜: 2026-10-20
- 언어: Java

---

### 문제 요약

연산 ⊕는 두 정수에 대한 연산으로 두 정수를 붙여서 쓴 값을 반환

양의 정수 `a`와 `b`가 주어졌을 때, `a` ⊕ `b`와 `2 * a * b` 중 더 큰 값을 return


### 접근 방법

- 더한 값이 이어서 붙여서 나올려면 숫자를 문자로 바꿔야했음. Integer.parseInt(”” + a+ b) 사용

### 막혔던 점 / 배운 점

-  Integer.parseInt(”” + a+ b) 사용을 처음에 헷갈려서 이 부분을 구글링을 통해서 찾았음

- 정수를 문자열로 만들어주는 부분은  (”” + a + b) 이었고, 다시 그 문자열을 정수로 만들어주는 코드가 
 Integer.parseInt 였음.

### 코드

```java
class Solution {
	public int solution(int a, int b) {
		int p = Integer.parseInt("" + a + b);
		int m = 2 * a * b;
		if (p >= m) {
			return p;
		} else {
			return m;
		}

	}
}
```
