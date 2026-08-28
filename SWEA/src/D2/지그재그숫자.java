package D2;

import java.util.Scanner;

public class 지그재그숫자 {
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N;
			N = sc.nextInt();
			int count = 0;
			int count2=0;
			int max=0;
			for(int i=1; i<=N; i++) {
				if(i %2 ==0) {
					count-=i;
				}else if(i%2!=0) {
					count2+=i;
				}
				max =count+count2;
			}
			System.out.println("#" + test_case +" " + max );
			
			

		}
	}
}
