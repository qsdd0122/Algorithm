import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFSBFS {
	static int[][] arr;
	static boolean[] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		
		arr = new int[N+1][N+1];
		
		for(int i=0;i<M;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y] = arr[y][x] = 1;
		}
		visited = new boolean[N+1];
		DFS(V);
		System.out.println();
		visited = new boolean[N+1];
		BFS(V);
	}
	
	public static void DFS(int V) {
		visited[V] = true;
		System.out.print(V+" ");
		if(V == arr.length) {
            return;
        }
		for(int j=1; j<arr.length;j++) {
			if(arr[V][j] == 1 && visited[j] == false) {
				DFS(j);
			}
		}
	}
	
	public static void BFS(int V) {
		Queue<Integer> que = new LinkedList<>();
		
		que.add(V);
		visited[V] = true;
		System.out.print(V+" ");
		while(!que.isEmpty()) {
			int temp = que.remove();
			for(int i=1;i<arr.length;i++) {
				if(arr[temp][i] == 1 && visited[i] == false) {
					visited[i] = true;
					que.add(i);
					System.out.print(i+" ");
				}
			}
		}
	}

}
