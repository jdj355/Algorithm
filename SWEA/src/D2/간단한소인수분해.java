
package D2;

import java.util.Scanner;

public class 간단한소인수분해 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			int N;
			N= sc.nextInt();
			
			int a = 0;
			int b= 0;
			int c =0;
			int d =0;
			int e =0;
			
			while(N % 2 ==0) {
				a++;
				N/=2;
				
			}
			while(N % 3 ==0) {
				b++;
				N/=3;
				
			}
			while(N % 5 ==0) {
				c++;
				N/=5;
			
			}
			while(N % 7 ==0) {
				d++;
				N/=7;
			}
			while(N % 11 ==0) {
				e++;
				N/=11;
				
			}
			System.out.println("#" + test_case + " "+ a +" "+ b +" "+ c+" "+ d+" "+ e);

		}
	}
}
