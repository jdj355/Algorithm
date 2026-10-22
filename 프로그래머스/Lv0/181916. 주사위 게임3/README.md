# [Lv0] 주사위 게임3

- 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/181916
- 유형: 구현
- 푼 날짜: 2026-10-22
- 언어: Java

---

### 문제 요약

1부터 6까지 숫자가 적힌 주사위가 네 개 있습니다. 네 주사위를 굴렸을 때 나온 숫자에 따라 다음과 같은 점수를 얻습니다.

- 네 주사위에서 나온 숫자가 모두 p로 같다면 1111 × p점을 얻습니다.

- 세 주사위에서 나온 숫자가 p로 같고 나머지 다른 주사위에서 나온 숫자가 q(p ≠ q)라면 (10 × p + q)2 점을 얻습니다.

- 주사위가 두 개씩 같은 값이 나오고, 나온 숫자를 각각 p, q(p ≠ q)라고 한다면 (p + q) × |p - q|점을 얻습니다.

- 어느 두 주사위에서 나온 숫자가 p로 같고 나머지 두 주사위에서 나온 숫자가 각각 p와 다른 q, r(q ≠ r)이라면 q × r점을 얻습니다.

- 네 주사위에 적힌 숫자가 모두 다르다면 나온 숫자 중 가장 작은 숫자 만큼의 점수를 얻습니다.

### 접근 방법

- 각 조건에 맞게 코드를 if 문으로 분류해서 작성했음



### 막혔던 점 / 배운 점

- 처음에 예시에 있는 코드로 하드코딩하다 보니 테스트 케이스에 서 통과 못한 부분이 많았음.

- 케이스 분류를 좀 더 디테일하게 진행하지 못했음.

- &&와 || 사용법이 살짝 헷갈렸는데 &&은 모든 조건이 만족해야하고, ||은 조건 중 한개만 맞아도 됨



### 코드

```java
class Solution {
	public int solution(int a, int b, int c, int d) {
		int answer = 0;
		// case 1
		if (a == b && b == c && c == d) {
			return answer = 1111 * a;
		}
		
		// case2
		if (a == b && b == c) {
			return answer = (10 * a + d) * (10 * a + d);
		}
		if (a == b && b == d) {
			return answer = (10 * a + c) * (10 * a + c);
		}
		if (b == c && c == d) {
			return answer = (10 * b+ a) * (10 * b + a);
		}
		if (a == c && c == d) {
			return answer = (10 * a + b) * (10 * a + b);
		}

		// case3
		if (a == b && c == d) {
			return answer = (a + c) * Math.abs(a - c);
		
		}
		if (b == c && a == d) {
			return answer = (b + a) * Math.abs(b - a);
		
		}
		if (a == c && b == d) {
			return answer = (a + b) * Math.abs(a - b);
		
		}
		
	
		// case4
		if (a == b) {
			return answer = c * d; 
		}
		if (a== c) {
			return answer = b * d; 
		}
		if (a == d) {
			return answer = b * c; 
		}
		if (b == c) {
			return answer = a * d; 
		}
		if (b == d) {
			return answer = a * c; 
		}
		if (c == d) {
			return answer = a * b; 
		}
		
		// case5
		if (a != b && a!=c && a!=d && b != c && c != d && a!=d) {
			return answer = Math.min(Math.min(a, b), Math.min(c, d));
			
		}

		return answer;
	}
}

```
