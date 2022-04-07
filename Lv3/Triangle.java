public class Triangle {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        for(int i=1;i<triangle.length;i++) {
            dp[i][0] = triangle[i][0]+dp[i-1][0];
            dp[i][triangle[i].length-1] = triangle[i][triangle[i].length-1]+dp[i-1][triangle[i-1].length-1];
        }

        for(int i=2;i< triangle.length;i++) {
            for(int j=1;j<triangle[i].length-1;j++) {
                int bignum = dp[i-1][j] >= dp[i-1][j-1] ? dp[i-1][j] : dp[i-1][j-1];
                dp[i][j] = triangle[i][j] + bignum;
            }
        }

        for(int i=0;i<dp[dp.length-1].length;i++) {
            int checkNum = dp[dp.length-1][i];
            if(checkNum >= answer) answer = checkNum;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] triangle = {{7},{3, 8}, {8, 1, 0}, {2, 7, 4, 4},{4, 5, 2, 6, 5}};
        Triangle t = new Triangle();
        System.out.println(t.solution(triangle));
    }
}
