package D2;

import java.util.Scanner;

public class 두개의숫자열 {
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N= sc.nextInt();
			int M = sc.nextInt();
			int A[] = new int[N];
			for(int i=0; i<N; i++) {
				A[i] = sc.nextInt();
			}
			int B[] = new int[M];
			for(int i=0; i<M; i++) {
				B[i] = sc.nextInt();
			}
			int[]longArr,shortArr;
			if(N>=M) {
				longArr = A;
				shortArr= B;
			}else {
				longArr =B;
				shortArr=A;
			}
			int max = Integer.MIN_VALUE;
			for(int s=0; s<=longArr.length-shortArr.length; s++) {
				int sum=0;
				for(int j=0; j<shortArr.length; j++) {
					sum+= longArr[s+j] * shortArr[j];
				}
				max = Math.max(max, sum);
			}
			System.out.println("#" + test_case + " " + max);
		 }
	  }
			
			
			
		
	}

