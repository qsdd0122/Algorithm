import java.util.LinkedList;
import java.util.Queue;

public class Network {
	static boolean[] visited;
	static int cnt;
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        cnt = 0;
        visited = new boolean[n];
        
        for(int i=0;i<visited.length;i++) {
        	if(visited[i] == false) BFS(computers, i);
        }
        
        return cnt;
    }
    
    private static void BFS(int[][] computers, int num) {
    	Queue<Integer> que = new LinkedList<>();
    	
    	que.add(num);
    	visited[num] = true;
    	System.out.print(num+" ");
    	while(!que.isEmpty()) {
    		int temp = que.remove();
    		for(int i=0;i<computers.length;i++) {
        		if(computers[temp][i] == 1 && visited[i] == false) {
        			visited[i] = true;
        			que.add(i);
        			System.out.print(i+" ");
        		}
        	}
    	}
    	System.out.println();
    	cnt++;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int[][] computers = {{1,1,0},{1,1,1},{0,1,1}};
		System.out.println(solution(n, computers));
	}

}
