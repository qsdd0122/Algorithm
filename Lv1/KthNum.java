import java.util.*;
class Solution {
    public static int solution(int[] nums) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	for(int i:nums) {
    		if(!list.contains(i)) list.add(i);
    	}
    	
    	int answer = list.size()*(list.size()-1)/2;
    	
        
        return answer;
    }        
}