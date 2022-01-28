import java.util.*;
public class Main {
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	private static int BFS(int x, int y) {
		int cnt = 1;
		Queue<Location> que = new LinkedList<>();
		que.add(new Location(x,y));
		visited[x][y] = true;
		
		while(!que.isEmpty()) {
			Location loc = que.poll();
			for(int i=0;i<4;i++) {
				int nextX = loc.x + dx[i];
				int nextY = loc.y + dy[i];
				if(nextX < 0 || nextY < 0 || nextX >= arr.length || nextY >= arr.length) continue;
				if(visited[nextX][nextY] || arr[nextX][nextY] == 0 ) continue;
				
				que.add(new Location(nextX,nextY));
				visited[nextX][nextY] = true;
				cnt++;
			}
		}
		
		return cnt;
	}
	
	private static class Location{
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
		sc.nextLine();
		arr = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			String str = sc.nextLine();
			for(int j=0;j<N;j++) {
				arr[i][j] = str.charAt(j)-'0';
				visited[i][j] = false;
			}
		}

		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<arr.length;i++) {
			for(int j=0; j<arr.length; j++) {
				if(arr[i][j] == 1 && !visited[i][j]) {
					//System.out.println(i+" "+j);
					int cnt = BFS(i,j);
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int i=0; i<list.size();i++) System.out.println(list.get(i)+" ");

	}

}
