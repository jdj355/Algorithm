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
