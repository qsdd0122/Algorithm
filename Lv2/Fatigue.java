
public class Fatigue {
	static boolean[] visited;
	static int cnt;
    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        cnt = 0;
        for(int i=0;i<dungeons.length;i++) {
        	visited[i] = true;
            DFS(k-dungeons[i][1], dungeons, i, 1);
            visited[i] = false;
        }
        
        return cnt;
    }
    
    private static void DFS(int k, int[][] dungeons, int index, int depth) {
    	cnt = cnt < depth ? depth : cnt;
    	if(depth == dungeons.length+1) return;
    	
    	for(int i=0;i<dungeons.length;i++) {
        	int mink = dungeons[i][0];
        	int needk = dungeons[i][1];
        	if(k >= mink && !visited[i]) {
        		visited[i] = true;
        		DFS(k-needk,dungeons,i,depth+1);
        		
        		visited[i] = false;
        	}
    	}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 80;
		int[][] dungeons = {{80,20},{50,40},{30,10}};
		System.out.println(solution(k,dungeons));
	}

}
