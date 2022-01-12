import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Printer {
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        int id = 0;
        int rank = 1;
        
        Queue<IdAndPriority> que = new LinkedList<>();

        for(int i: priorities) {
        	IdAndPriority iap = new IdAndPriority(id,i);
        	que.add(iap);
        	id++;
        	
        }
        
        Arrays.sort(priorities);
        int index = priorities.length-1;
        
        while(!que.isEmpty()) {
        	//가장 높은 중요도일 떄
        	if(que.peek().priority >= priorities[index]) {
        		// 빼낸 문서가 해당 문서일 경우
        		if(que.peek().id == location) {
        			que.poll();
        			answer = rank;
        			index--;
        			break;
        		}
        		// 아닐 경우
        		else {
        			que.poll();
        			rank++;
        			index--;
        		}
        	} 
        	// 더 높은 중요도가 있을 경우
        	else {
        		int temp_id = que.peek().id;
        		int temp_pri = que.poll().priority;
        		IdAndPriority iap = new IdAndPriority(temp_id, temp_pri);
            	que.add(iap);
        	}
        }
        
        return answer;
    }
    
    public static class IdAndPriority {
    	public int id;
    	public int priority;

    	public IdAndPriority(int id, int priority) {
    		this.id = id;
    		this.priority = priority;
    	}
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;
		System.out.println(solution(priorities, location));
	}

}
