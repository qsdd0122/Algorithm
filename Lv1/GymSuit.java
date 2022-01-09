import java.util.*;
class Solution {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        
        HashMap<Integer,String> map = new HashMap<Integer,String>();
        for(int i:lost) map.put(i, "lost");
        for(int i:reserve) {
        	if(map.containsKey(i) == true) {
        		map.remove(i);
        		answer++;
        	
        	}
        	else map.put(i, "reserve");
        }
        
        Iterator<Integer> keys = map.keySet().iterator();
        ArrayList<Integer> k = new ArrayList<Integer>();
        while(keys.hasNext()){
            int key = keys.next();
            k.add(key);
            System.out.println("[Key]:" + key + " [Value]:" +  map.get(key)+" total:"+answer);
        }

        
        for(int i:k) {
        	if(map.get(i) == "lost" && map.get(i-1) == "reserve") { 
        		map.remove(i-1); 
        		map.remove(i);
        		answer++;
        	}
        	else if(map.get(i) == "lost" && map.get(i+1) == "reserve") { 
        		map.remove(i+1); 
        		map.remove(i);
        		answer++;
        	}
        }
        return answer;
    }
}