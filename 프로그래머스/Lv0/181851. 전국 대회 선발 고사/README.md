# [Lv0] 전국 대회 선발 고사

- 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/181851
- 유형: 구현
- 푼 날짜: 2026-10-23
- 언어: Java

---

### 문제 요약

등수가 높은 3명을 선발해야 하지만, 개인 사정으로 전국 대회에 참여하지 못하는 학생들이 있어 참여가 가능한 학생 중 등수가 높은 3명을 선발
전국 대회에 선발된 학생 번호들을 등수가 높은 순서대로 각각 a, b, c번이라고 할 때 10000 × a + 100 × b + c를 return

### 접근 방법

- attendance가 true인 학생의 rank 인덱스를 list를 선언해서 담기

- list에 든 인덱스들을, rank 값을 기준으로 정렬했다
→ 람다식으로 오름차순으로 정렬

### 막혔던 점 / 배운 점

- 제일 막혔던 부분은 list에 담은 값들은 인덱스 번호를 담았는데, 이 인덱스에 실제 해당하는 값들을 rank를 정렬하고 그 인덱스를 차례대로 값에 맞게 출력하는거였음.

- 람다식으로 정렬하면  rank의 값을 기준으로 list에 담은 인덱스값을 오름차순 정렬 할 수 있었음.

### 코드

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
	public int solution(int[] rank, boolean[] attendance) {
		List<Integer> list = new ArrayList<>();
		int answer = 0;
		for (int i = 0; i < attendance.length; i++) {
			if (attendance[i] == true) {
				list.add(i);
			}
		}
		list.sort((a, b) -> (rank[a] - rank[b]));

		return answer = 10000 * list.get(0) + 100 * list.get(1) + list.get(2);
	}
}
```
