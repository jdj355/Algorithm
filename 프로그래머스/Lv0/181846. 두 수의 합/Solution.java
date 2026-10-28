
class Solution {
	public String solution(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1; // 이게 맨 뒷자리 인덱스이니까 여기부터 시작하겠다는 소리임
		int j = b.length() - 1; // 이것도 마찬가지임
		int carry = 0; // 10이상이되면 +1 되는 숫자를 담는 변수임

		while (i >= 0 || j >= 0 || carry > 0) { // a나 b에 숫자가 남아있거나, 올릴 숫자가 남아있으면 계속 진행
			int x = (i >= 0) ? a.charAt(i) - '0' : 0; // 숫자가 남아있으면 그 문자를 숫자로 변경하고 숫자가 남아있지 않으면 0으로
			int y = (j >= 0) ? b.charAt(j) - '0' : 0;

			int sum = x + y + carry; // 두값을 더한다 + 이전의 넘어온 +1의 값
			sb.append(sum%10); // 10으로 나눈 나머지값을 sb 붙인다. -> ex) 7+8 =15, 15%10-> 5이기에 일의자리 숫자만 뽑을 수 있음.
			carry = sum/10; // carry에는 +1 값을 넣는다. ex) sum= 15 -> 15/10은 1이기에 10이상 +1의 값만 뽑을 수 있게됨.
			
			i--; // 맨마지막 인덱스부터 시작하기에 --를 해서 왼쪽 인덱스로 이동한다.
			j--;
		}

		return sb.reverse().toString(); // 맨오른쪽 인덱스부터 더해서 붙였기에 reverse를 해줘야 원래대로 더한 값이 정상적으로 출력됨.

	}
}

//a의 끝자리부터 b의 끝자리를 뽑아서 10이상 넘어가면 다음자리로 넘어가고 +1을 해준다ㅣ. 
//a의 마지막 인덱스를 charAt으로 뽑고 b의 마지막 인덱스도 charAt으로 뽑아서 두개의 값을 더해
// 그리고 그 더한값이 10을 넘어가면 그 다음 값에 +1을해준다.
// 끝자리를 더해서 10이 넘어가면 그 다음 코드에 +1을 해주는데 그 코드는 어떻게 작성하지?
// 그리고 두개를 다 더해서 sb.append하고 reverse해줘야함.
