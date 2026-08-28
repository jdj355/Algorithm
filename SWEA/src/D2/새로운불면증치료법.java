package D2;

import java.util.Scanner;

public class 새로운불면증치료법 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int sum[] = new int[10];
			int N;
			N = sc.nextInt();
			int count = 0;
			int i =1;
			int M = 0;
			while(count<10) {
				M = N * i;
				int temp =M;
			while(temp > 0) {
				int digit= temp % 10;
				if(sum[digit]==0) {
					count++;
				}
				sum[digit]++;
				temp/=10;
			}
			i++;
			}
			System.out.println("#" + test_case +  " " + M);
		}
	}
	
}
