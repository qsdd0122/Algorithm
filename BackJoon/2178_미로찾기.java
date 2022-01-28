import java.util.*;

public class BFSMaze {
	static int answer = 1;
	static int[][] maze;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	private static void BFS(int x, int y) {
		
		Queue<Location> que = new LinkedList<>();
		que.add(new Location(x,y));
		
		while(!que.isEmpty()) {
			Location loc = que.poll();
			for(int i=0; i<4; i++) {
				int nextX = loc.x + dx[i];
				int nextY = loc.y + dy[i];
				//System.out.println(nextX+" "+nextY );
				//다음 좌표가 배열 넘어가거나 방몬한좌표, 0인 좌표일 경우
				if(nextX < 0 || nextX >= maze.length || nextY < 0|| nextY >=maze[0].length
						|| visited[nextX][nextY] || maze[nextX][nextY] == 0) {
					continue;
				}
				
				que.add(new Location(nextX,nextY));
				visited[nextX][nextY] = true;
				maze[nextX][nextY] = maze[loc.x][loc.y]+1;
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
		int N = sc.nextInt();
		int M = sc.nextInt();
		maze = new int[N][M];
		visited = new boolean[N][M];
		sc.nextLine();
		for(int i=0; i<N; i++) {
			String str = sc.nextLine();
			for(int j=0; j<M; j++) {
				maze[i][j] = str.charAt(j)-'0';
				visited[i][j] = false;
			}
		}
		visited[0][0] = true;
		BFS(0,0);
		System.out.println(maze[N-1][M-1]);
	}

}
