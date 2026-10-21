# [Lv0] 정수를 나선형으로 배치하기

- 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/181832
- 유형: 구현
- 푼 날짜: 2026-10-21
- 언어: Java

---

### 문제 요약

2차원 배열을 나선형으로 돌면서 숫자 대입하

### 접근 방법

- 예시 코드를 바탕으로 범위를 나눠서 바깥쪽 코드 범위를 작성했음 

### 막혔던 점 / 배운 점

- 우선 코드 범위를 나누면서 시작 범위와 끝 범위 설정 하는데 헷갈렸음. 그리고 이차원 배열에 실제 값을 대입을 해야하는데 그 값을 제대로 넣지 못했음.

- 애초에 시작할 때부터 경계 부분을 상,하,좌,우의 값을 선언하고 시작하는게 코드 작성에 더 편했음.  
바깥쪽 코드를 작성하고 안에 

### 코드

```java
class 정수를나선형으로배치하기 {

	public int[][] solution(int n) {
		int[][] answer = new int[n][n];
		int top = 0;
		int bottom = n - 1;
		int left = 0;
		int right = n - 1;
		int num = 1;
		while (top <= bottom) {

			for (int j = left; j <= right; j++) {
				answer[top][j] = num;
				num++;
			}

			for (int i = top + 1; i <= bottom; i++) {
				answer[i][right] = num;
				num++;
			}

			for (int j = right - 1; j >= left; j--) {
				answer[bottom][j] = num;
				num++;
			}

			for (int i = bottom - 1; i >= top + 1; i--) {
				answer[i][left] = num;
				num++;
			}

			top++;
			bottom--;
			left++;
			right--;

		}

		return answer;
	}
}
```
