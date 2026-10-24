# [Lv0] 정사각형으로 만들기

- 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/181830
- 유형: 구현
- 푼 날짜: 2026-10-24
- 언어: Java

---

### 문제 요약

이차원 정수 배열 `arr`이 매개변수로 주어집니다. `arr`의 행의 수가 더 많다면 열의 수가 행의 수와 같아지도록 각 행의 끝에 0을 추가하고, 열의 수가 더 많다면 행의 수가 열의 수와 같아지도록 각 열의 끝에 0을 추가한 이차원 배열을 return 하는 solution 함수를 작성



### 접근 방법

- arr[0]의 길이와 arr의 길이 중에 더 큰 값을 n으로 잡는다. 그리고 n의 값으로 [n][n] 2차원  정사각형 배열을 만든다. 반복문을 돌면서 새로 만든 answer 배열에 기존에 arr값들을 넣으면 나머지 빈 배열칸들은 0이기에 조건을 만족한 배열이 됨.


### 막혔던 점 / 배운 점

- 막혔던 부분은 비교하는 값을 arr의 길이와 arr[0]을 비교하려다가 행의 길이들로 비교해서 값을 잘못 비교함


- 그리고 if문으로 행의 수가 더 많을때와 열의 수가 더 많을때를 나눠서 비교하고 0을 추가하는 방식으로 접근했음.
 → 배열은 고정되어있기에 새로 Arraylist로 옮기고 0을 붙이고, 다시 배열로 바꿔야해서 복잡해짐.

- 비교하는 값을 확실히 정하고, 그에 따라 2차원 배열의 크기를 Math.max로 n의 크기로 정하는 코드가 깔끔하고 0을 붙이지 않고 해결하는 좋은 코드였음.

### 코드

```java
class Solution {
	public int[][] solution(int[][] arr) {
		int n = Math.max(arr.length, arr[0].length);
		int[][] answer = new int[n][n];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {

				answer[i][j] = arr[i][j];

			}
		}

		return answer;
	}
}

```
