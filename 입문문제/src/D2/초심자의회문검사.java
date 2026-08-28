package D2;

import java.util.Scanner;

public class 초심자의회문검사 {
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String S;
			S= sc.next();
			boolean t = true;
			for(int i=0; i<=S.length()-1; i++) {
				if(S.charAt(i)!= S.charAt(S.length()-1-i)) {
					t= false;
					break;
				}
			}
			System.out.println("#" + test_case+ " "+ (t ? 1 : 0));

		}
		
	}
}
