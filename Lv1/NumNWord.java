import java.util.*;
class Solution {
    public static int solution(String s) {
        int answer = 0;
        String[] strarr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"}; 
        String[] intarr = {"0","1","2","3","4","5","6","7","8","9"};
        
        
        
        for(int i=0;i<strarr.length;i++) {
        	s = s.replaceAll(strarr[i], intarr[i]);
        }
        
        return Integer.parseInt(s);
    }
}