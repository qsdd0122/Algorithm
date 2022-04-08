import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class School {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        int[][] road = new int[n][m];
        for(int[] r:road) Arrays.fill(r,-1);
        boolean flag = false;
        for(int i=0;i< puddles.length;i++) {
            road[puddles[i][1]-1][puddles[i][0]-1] = 0;
        }

        for(int i=0;i<road.length;i++) {
            if(road[i][0] == 0) {
                flag = true;
                road[i][0] = 0;
            }
            if(flag == false) road[i][0] = 1;
            else road[i][0] = 0;
        }

        flag = false;
        for(int i=0;i<road[0].length;i++) {
            if(road[0][i] == 0) {
                flag = true;
                road[0][i] = 0;
            }
            if(flag == false) road[0][i] = 1;
            else road[0][i] = 0;
        }

        for(int i=1;i<road.length;i++) {
            for(int j=1;j<road[i].length;j++) {
                if(road[i][j] == -1) {
                    road[i][j] = (road[i][j-1] + road[i-1][j])%1000000007;
                }
            }
        }

        /*for(int i=0;i<road.length;i++) {
            for(int j=0;j<road[i].length;j++) {
                System.out.print(road[i][j]+" ");
            }
            System.out.println();
        }*/

        return road[n-1][m-1]%1000000007;
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 4;
        int[][] puddles = {{2,3},{4,2}};
        School school = new School();
        System.out.println(school.solution(m,n,puddles));
    }
}
