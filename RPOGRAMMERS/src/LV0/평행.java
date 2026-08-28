package LV0;

public class 평행 {
	class Solution {
	    public int solution(int[][] dots) {
	    	int[][] pairs = {{0,1,2,3},{0,2,1,3},{0,3,1,2}};
	        
	        for(int[] p : pairs) {
	        	int dy1 = dots[p[1]][1]- dots[p[0]][1];
	        	int dx1 = dots[p[1]][0]- dots[p[0]][0];
	        	int dy2 = dots[p[3]][1]- dots[p[2]][1];
	        	int dx2 = dots[p[3]][0]- dots[p[2]][0];
	        		
	        	if(dy1 * dx2 == dy2 * dx1) return 1;
	        	}
	        
	        return 0; 
	    }
	}
}




















