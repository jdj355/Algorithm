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
