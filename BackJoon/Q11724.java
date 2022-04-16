import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q11724 {
    static int[][] graph;
    static boolean[] visited;
    static int count = 0;
    private static void BFS(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;
        while (!que.isEmpty()) {
            int n = que.poll();
            for(int i=1;i< graph.length;i++) {
                if(graph[n][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    que.add(i);
                }
            }
        }
        count++;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];
        for(int i=0;i<M;i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = graph[y][x] = 1;
        }
        for(int i=1;i<N+1;i++) {
            if(!visited[i]) BFS(i);
        }
        System.out.println(count);
    }
}
