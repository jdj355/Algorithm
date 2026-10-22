class Solution {
	public int solution(int a, int b, int c, int d) {
		int answer = 0;
		// case 1
		if (a == b && b == c && c == d) {
			return answer = 1111 * a;
		}
		
		// case2
		if (a == b && b == c) {
			return answer = (10 * a + d) * (10 * a + d);
		}
		if (a == b && b == d) {
			return answer = (10 * a + c) * (10 * a + c);
		}
		if (b == c && c == d) {
			return answer = (10 * b+ a) * (10 * b + a);
		}
		if (a == c && c == d) {
			return answer = (10 * a + b) * (10 * a + b);
		}

		// case3
		if (a == b && c == d) {
			return answer = (a + c) * Math.abs(a - c);
		
		}
		if (b == c && a == d) {
			return answer = (b + a) * Math.abs(b - a);
		
		}
		if (a == c && b == d) {
			return answer = (a + b) * Math.abs(a - b);
		
		}
		
	
		// case4
		if (a == b) {
			return answer = c * d; 
		}
		if (a== c) {
			return answer = b * d; 
		}
		if (a == d) {
			return answer = b * c; 
		}
		if (b == c) {
			return answer = a * d; 
		}
		if (b == d) {
			return answer = a * c; 
		}
		if (c == d) {
			return answer = a * b; 
		}
		
		// case5
		if (a != b && a!=c && a!=d && b != c && c != d && a!=d) {
			return answer = Math.min(Math.min(a, b), Math.min(c, d));
			
		}

		return answer;
	}
}
