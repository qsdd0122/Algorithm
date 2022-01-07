import java.util.*;
class Solution {
    public static int solution(int[] numbers) {
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=0;i<10;i++) arr.add(i);
        for(int i : numbers) arr.remove(Integer.valueOf(i));
        for(int i=0;i<arr.size();i++) {
        	answer += arr.get(i);
        }
        
        return answer;
    }
}