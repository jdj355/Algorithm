# [Lv0] 배열 만들기 2

- 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/181921
- 유형: 구현
- 푼 날짜: 2026-10-23
- 언어: Java

---

### 문제 요약

l 이상 r 이하의 정수 중에서 숫자  "0"과  "5"로만 이루어진 모든 정수를 오름차순으로 저장한 배열 return

### 접근 방법

- i를 l 부터 r까지의 반복문으로 돌리고  문자열 s를 만들어서 i를 s에 담는다. j를 0부터 s의 길이만큼 돌려서 charAt으로 ‘0’ 또는  ‘5’에 일치하면 continue 
ex) ‘5503’ → 5(continue) , 5(continue) , 0(break) 

- ‘0’또는 ‘5’값이 없으면 flag =false 바꾸고 break

- flag==true일때, list를 만들어서 배열에 문자열 s를 정수로 바꾸고  추가

-  answer 배열을 list 크키가 만큼 똑같이 만들고 값 하나씩 대입

- list의 크기가 0이면 -1 출력

### 막혔던 점 / 배운 점

- 필요한 부분에서 배열을 적절히 선언하고,  조건에 맞게 범위를 잘 설정하는 부분에 대해서 배울 수 있었음.

- boolean형을 선언하고 특정 조건일때, false로 바꿔야하는데 그 바꾸는 위치가 헷갈렸음.

- continue, break 사용법을 더 잘 알게 됨. 

### 코드

```java
import java.util.ArrayList;
import java.util.List;

class 배열만들기2 {
	public int[] solution(int l, int r) {

		List<Integer> list = new ArrayList<>();

		for (int i = l; i <= r; i++) {
			String s = String.valueOf(i);
			boolean flag = true;
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '0' || s.charAt(j) == '5') {
					continue;

				} else {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				list.add(Integer.parseInt(s));
			}
		}
		int answer[] = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		if (list.size() == 0) {
			return new int[] { -1 };
		}

		return answer;
	}
}

```
