import java.util.PriorityQueue;

public class Scoville {
	
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        
        //배열 값을 큐에 입력
        for(int i : scoville) {
        	que.add(i);
        }
        
        while(que.peek()<K) {
	        int first = que.poll();
	        int second = que.poll();
	        int sum = first + (second*2);
	        que.add(sum);
	        answer++;
	        
	        //마지막 남은 원소가 K 보다 작으면 K이상으로 만들수 없음
	        if(que.size() == 1 && que.peek() < K) return -1;
        }
        
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scoville = {1,1,1};
		int K = 2;
		
		System.out.println(solution(scoville, K));
	}

}
