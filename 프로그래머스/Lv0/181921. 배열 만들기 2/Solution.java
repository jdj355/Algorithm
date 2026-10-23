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
