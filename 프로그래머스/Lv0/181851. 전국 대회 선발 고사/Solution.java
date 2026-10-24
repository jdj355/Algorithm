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
