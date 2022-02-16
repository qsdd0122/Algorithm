import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class TruckBridge {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int elapsedTime = 0;
       
        LinkedList<int[]> bridge = new LinkedList<>();
        int current_weight = 0;
        int complete = 0;
        int index = 0;

        while(complete != truck_weights.length) {

        	int truck_weight = truck_weights[index];
        	
        	if(bridge.size() != 0 && bridge.peek()[1] == bridge_length ) {
        		current_weight -= bridge.poll()[0];
        		complete++;
        	}
        	
        	if(current_weight+truck_weight <= weight) {
        		bridge.add(new int[]{truck_weight,0});
        		current_weight += truck_weight;
            	if(index < truck_weights.length-1)index++;
        	}
        	
        	elapsedTime++;
        	// 시간 1씩 증가
        	for(int i=0;i<bridge.size();i++) {
        		bridge.get(i)[1]++;
        	}
        }
        
        
        return elapsedTime;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10};
		System.out.println(solution(bridge_length, weight, truck_weights));
	}

}
