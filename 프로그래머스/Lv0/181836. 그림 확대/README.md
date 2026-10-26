# [Lv0] 그림 확대

- 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/181836
- 유형: 구현
- 푼 날짜: 2026-10-26
- 언어: Java

---

### 문제 요약

직사각형 형태의 그림 파일이 있고, 이 그림 파일은 1 × 1 크기의 정사각형 크기의 픽셀로 이루어져 있습니다. 이 그림 파일을 나타낸 문자열 배열 `picture`과 정수 `k`가 매개변수로 주어질 때, 이 그림 파일을 가로 세로로 `k`배 늘린 그림 파일을 나타내도록 문자열 배열을 return 하는 solution 함수를 작성



### 접근 방법

- 각 행(`picture[i]`)의 글자를 하나씩 꺼내서 **가로로 k번씩** 이어 붙인다

- 그렇게 완성된 한 줄을 **세로로 k번** 반복한다

- 결과 줄 개수가 유동적이니 **List에 모은다**

### 막혔던 점 / 배운 점

- 막혔던 




- **“k배 / k번 / k개 이어 붙이기” = for문으로 k번 append.** 횟수 세는 변수는 안에서 안 써도 됨

- **`picture[i].charAt(j)`** = i번째 행의 j번째 글자. 인덱스는 자리마다 역할을 정해서 넣기

### 코드

```java

import java.util.ArrayList;
import java.util.List;

class Solution {
	public Object[] solution(String[] picture, int k) {
		List<String> list = new ArrayList<>();

		for (int i = 0; i < picture.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < picture[i].length(); j++) {
				for (int t = 0; t < k; t++) {
					sb.append(picture[i].charAt(j));

				}
				
				}
			for(int r=0; r<k; r++) {
				list.add(sb.toString());
			}
			
			// picture[i]룰 뽑아서 그 문자열을 하나씩 char로 바꾼 후, 그 각각 char를 k만큼 곱해서 sb.append한다.
			// 그리고 그 나온 문자열을 k만큼 곱해서 만들어야함.
			// 그 담을 공간이 list 만들면 유동적이라서 괜찮지 않을까?

		}
		return list.toArray();

	}
}

```
