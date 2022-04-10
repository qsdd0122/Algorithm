    import java.util.*;

public class FarNode {
    static boolean[] visited;
    public int solution(int n, int[][] edge) {
        int answer=0;
        boolean[][] graph = new boolean[n+1][n+1];
        for(int i=0;i<graph.length;i++) graph[i][0] = false;
        for(int i=0;i<graph[0].length;i++) graph[0][i] = false;

        visited = new boolean[n+1];

        for(int i=0;i<edge.length;i++) {
            graph[edge[i][0]][edge[i][1]] = graph[edge[i][1]][edge[i][0]] = true;
        }

/*        for(int i=0;i< graph.length;i++) {
            for(int j=0;j<graph[i].length;j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }*/

        answer = BFS(graph);

        return answer;
    }

    private int BFS(boolean[][] graph) {
        visited[1] = true;
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        int size = 0;
        while (!que.isEmpty()) {
            int queSize = que.size();
            for(int k=0;k<queSize;k++) {
                int num = que.poll();
                for (int i = 1; i < graph[num].length; i++) {
                    if (graph[num][i] && !visited[i]) {
                        que.add(i);
                        visited[i] = true;
                    }
                }
            }
            if(que.size() == 0) break;
            size = que.size();
        }
        return size;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6},{4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        FarNode fn = new FarNode();
        System.out.println(fn.solution(n,edge));
    }
}
