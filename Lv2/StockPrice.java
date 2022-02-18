import java.util.*;

public class StockPrice {
	
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];        
        
        for(int i=0;i<prices.length;i++) {
        	int cnt = 0;
        	for(int j=i+1;j<prices.length;j++) {
        		if(prices[i] > prices[j]) {
        			cnt++;
        			break;
        		} else cnt++;
        	}
        	answer[i] = cnt;
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1,2,3,2,3};
		System.out.println(solution(prices));
	}

}
