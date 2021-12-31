import java.util.*;
class Solution {
    public static int solution(String s) {
        int answer = 0;        
        int max_len = s.length()/2;
        ArrayList<Integer> arr = new ArrayList<>();
        String s_split = "";
        String next_split = "";
        int ans_len=0;
        String prev = "";
        
        for(int len=1; len<=max_len; len++) {
        	ans_len = s.length();
        	prev="";
        	int cnt=1;
        	for(int index=0;index<s.length();index+=len) {
        		if(index+len>s.length()) break;
        		s_split = s.substring(index,index+len);
        		
                next_split = s.substring(index+len,index+2*len<s.length()?index+2*len:s.length());
                
               if(s_split.equals(next_split)) {
                	ans_len -= len;
                	cnt++;

                	if(!s_split.equals(prev)) ans_len += 1;
                	
                } else {
                	if(cnt>=10) ans_len++;
                	cnt = 1;
                }
                prev = s_split;
        	}
        	//System.out.println("ans " + ans_len);
        	arr.add(ans_len);
        }
        
        
        return s.length()==1?1:Collections.min(arr);
    }
}