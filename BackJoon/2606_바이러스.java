import java.util.*;
public class Main {
	static int[][] arr;
	static boolean[] visited;
	
	private static int BFS(int num) {
		int cnt = 0;
		Queue<Integer> que = new LinkedList<>();
		que.add(num);
		
		while(!que.isEmpty()) {
			int temp = que.poll();
			for(int i=1; i<arr.length; i++) {
				if(arr[temp][i] == 1 && !visited[i]) {
					que.add(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
		return cnt;
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
		int line = sc.nextInt();
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i=0; i<line; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y] = arr[y][x] = 1;
		}
		
		visited[1] = true;
		System.out.print(BFS(1));
	
	}
}
