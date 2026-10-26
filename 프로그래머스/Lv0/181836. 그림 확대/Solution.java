
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
