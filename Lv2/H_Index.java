import java.util.Arrays;

public class H_Index {
    public static int solution(int[] citations) {
        int answer = 0;
        int compH = 0;
        Arrays.sort(citations);
        int max = citations[citations.length-1];
        
        for(int h=0;h<=max;h++) {
        	compH = 0;
        	for(int i: citations) {
        		if(h<=i) {
        			compH++;
        		}
        		if(h <= compH) answer = h > answer? h:answer;
        	}
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = {3,1,1,1,4};
		System.out.println(solution(citations));
	}

}
