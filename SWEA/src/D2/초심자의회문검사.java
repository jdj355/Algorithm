package D2;

import java.util.Scanner;


/* Scanner 문자열 받을때는 sc.next() 혹은 sc.nextLine()을 사용함.	
   sc.next() 와 sc.nextLine()차이
   sc.next()는 공백을 건너뛰고 출력 / sc.nextLine()은 개행 전까지 (한 줄 전체)
*/
 
public class 초심자의회문검사 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String S;
			S= sc.next();
			boolean P = true;
			
			for(int i=0; i<S.length()/2; i++) {
				if(S.charAt(i) != S.charAt(S.length()-1-i)) {
					 P =false;
					 break;
				}
			
		}
		
		
			System.out.println("#" + test_case + " " + (P ? 1 : 0)  );
	}
 }
	
}
