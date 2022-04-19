import java.util.LinkedList;
import java.util.Queue;

public class Sol1 {
    boolean[] visited;
    int[] countarr;
    int count;
    public int[] solution(int N, int[][] relation) {
        int[] answer = new int[N];

        int[][] graph = new int[N+1][N+1];
        for(int i=0;i<relation.length;i++) {
            graph[relation[i][0]][relation[i][1]]=graph[relation[i][1]][relation[i][0]] =  1;
        }
        countarr = new int[N+1];
        for(int i=1;i<N+1;i++) {
            count = 0;
            visited = new boolean[N+1];
            visited[i] = true;
            countarr[i] = 0;
            dfs(N, i, graph, 0);
            answer[i-1] = count;
        }

        return answer;
    }

    public void dfs(int n, int node, int[][] graph,int depth) {
        if(depth >= 2) return;
        for(int i=1;i<=n;i++){
            if(!visited[i] && (graph[node][i]==1||graph[i][node]==1)){
                visited[i] = true;
                countarr[i]++;
                dfs(n,i,graph,depth+1);
            }
        }
    }


    public static void main(String[] args) {
        int N = 5;
        int[][] relation = {{1,2},{4,2},{3,1},{4,5}};
        Sol1 sol1 = new Sol1();
        System.out.println(sol1.solution(N,relation));
    }
}
