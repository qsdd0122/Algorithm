import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1697 {
    static int count = 0;
    static boolean[] visited = new boolean[100001];

    private static void BFS(int start, int end) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{start,0});

        while (!que.isEmpty()) {
            int[] n = que.poll();
            if(n[0] == end) {
                count = n[1];
                return;
            }
            visited[n[0]] = true;
            if(n[0]-1>=0 && n[0]-1<= 100000 && !visited[n[0]-1]) que.add(new int[]{n[0]-1,n[1]+1});
            if(n[0]+1>=0 && n[0]+1<= 100000 && !visited[n[0]+1]) que.add(new int[]{n[0]+1,n[1]+1});
            if(n[0]*2>=0 && n[0]*2<= 100000 && !visited[n[0]*2]) que.add(new int[]{n[0]*2,n[1]+1});
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        //DFS(start,end,0);
        BFS(start, end);
        System.out.println(count);
    }
}
