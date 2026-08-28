package D2;
import java.util.Scanner;

class 수도요금경쟁
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int P = sc.nextInt();
			int Q = sc.nextInt();
			int R = sc.nextInt();
			int S = sc.nextInt();
			int W = sc.nextInt();
			
			int A = W * P;
			int B = (W>R) ? Q + (W-R) * S : Q;
			
			
			System.out.println("#" + test_case + " " + ((A > B) ? B : A )) ;
		}
	}
	
}