package D2;

import java.util.Scanner;

public class 패턴마디의길이 {
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String S;
			S= sc.next();
			// 생각한 로직: 입력받은 문자열을 내가 원하는 만큼 자르고 그것의 문자열의 길이를 출력하는건?
			// 문자열 자르기 substring(시작, 끝) -> 시작은 포함, 끝은 미포함
			for(int len =1; len<=10; len++) {
			//	S.substring(0, i).equals(S.substring(i, i * 2));
				boolean ok =true;
				for(int j=0; j<S.length(); j++) {
					if(S.charAt(j)!= S.charAt(j % len)){
						ok = false;
						break;
					}
				}
				if(ok) {
					System.out.println("#" + test_case +" " + len);
					break;
				}
			}
			
		}
	}
}
