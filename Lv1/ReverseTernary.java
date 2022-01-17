import java.util.*;
import java.util.Map.Entry;
class Solution {
    public static int solution(int n) {
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int index = 0;
        
        while(n/3 != 0) {
        	//System.out.println(n/3+" "+n%3);
        	arr.add(n%3);
        	index++;
        	n /=3;
        	
        } arr.add(n%3);
        
       
        for(int i=0;i<arr.size();i++) {
        	answer += arr.get(index)*Math.pow(3, i);
        	index--;
        }
        
        return answer;
    }
}