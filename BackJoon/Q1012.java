import java.util.*;
public class Q1012 {
	static int[][] cabbage;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	static int N,M,K;
	
	private static void BFS(int x, int y) {
		Queue<Location> que = new LinkedList<>();
		que.add(new Location(x,y));
		
		while(!que.isEmpty()) {
			Location loc = que.poll();
			int nextX, nextY;
			for(int i=0;i<dx.length;i++) {
				nextX = loc.x + dx[i];
				nextY = loc.y + dy[i];
				if(nextX<0 || nextX>=M || nextY<0 || nextY>=N || 
						cabbage[nextX][nextY] == 0 || visited[nextX][nextY]) continue;
				que.add(new Location(nextX,nextY));
				visited[nextX][nextY] = true;
			}
		}
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
		Scanner sc = new Scanner(System.in);
		int numTC = sc.nextInt();
		int[] answer = new int[numTC];
		for(int tc=0;tc<numTC;tc++) {
			int count=0;
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			cabbage = new int[M][N];
			visited = new boolean[M][N];
			for(int j=0;j<K;j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				cabbage[x][y] = 1;
			}
			
			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++) {
					if(cabbage[i][j] == 1 && !visited[i][j]) {
						BFS(i,j);
						count++;
					}
				}
			}
			answer[tc] = count;
		}
		for(int i:answer) System.out.println(i);
	}

}
