import java.util.*;

public class ColoringBook {
    static int numberOfArea;
    static int maxSizeOfOneArea;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static int[] solution(int m, int n, int[][] picture) {
    	numberOfArea = 0;
    	maxSizeOfOneArea = 0;
    	visited = new boolean[m][n];
    	
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<n;j++) {
    			if(visited[i][j] == false && picture[i][j] != 0) {
    				System.out.println(i+" "+j);
    				numberOfArea++;
    		    	visited[i][j] = true;
    				BFS(picture,i,j);
    			}
    		}
    	}
    	
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        System.out.println(answer[0]+" "+answer[1]);
        
        return answer;
    }
    
    private static void BFS(int[][] picture, int x, int y) {
    	Queue<Location> que = new LinkedList<>();
    	que.add(new Location(x,y));
    	int num = picture[x][y];
    	int cnt = 1;
    	
    	while(!que.isEmpty()) {
    		Location loc = que.poll();
    		for(int i=0;i<4;i++) {
    			int nextX = dx[i] + loc.x;
    			int nextY = dy[i] + loc.y;
    			
    			if(nextX < 0 || nextX >= picture.length || nextY < 0 || nextY >= picture[0].length) continue;
    			if(visited[nextX][nextY] || picture[nextX][nextY] != num) continue;
    			
    			que.add(new Location(nextX,nextY));
    			visited[nextX][nextY] = true;
    			cnt++;
    		}
    	}
    	maxSizeOfOneArea = maxSizeOfOneArea > cnt ? maxSizeOfOneArea : cnt;
    }
    
    
    private static class Location {
    	int x;
    	int y;
		public Location(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 6;
		int n = 4;
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		solution(m,n,picture);
	}

}
