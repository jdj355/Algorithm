import java.util.*;


class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        
        
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<s; i++) {
        		sb.append(my_string.charAt(i));
        }
        for(int j=0; j<overwrite_string.length(); j++) {
        	sb.append(overwrite_string.charAt(j));
        }
        for(int k=overwrite_string.length()+s; k<my_string.length(); k++) {
        	sb.append(my_string.charAt(k));
        }
        
        return sb.toString();
        
    }
}
