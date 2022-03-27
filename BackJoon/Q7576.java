import java.util.*;
public class Q7576 {
	static int[][] tomato;
	static boolean[][] visited;
	
	private static void BFS(int i, int j) {
		
	
	}
	
	private class Location {
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
		int M,N;
		M = sc.nextInt();
		N = sc.nextInt();
		for(int i=0;i<N;i++) {
			String str = sc.nextLine();
			for(int j=0;j<M;j++) {
				tomato[i][j] = str.charAt(j)-'0';
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(tomato[i][j]==1)
				BFS(i,j);
				visited[i][j] = true;
			}
		}
	}

}
