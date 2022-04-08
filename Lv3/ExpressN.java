public class ExpressN {
    static int answer = Integer.MAX_VALUE;
    public int solution(int N, int number) {
        DFS(N,number,0,0);

        return answer > 8? -1:answer;
    }

    private void DFS(int N,int number,int count, int sum) {
        if(count > 8) return;
        if(sum == number) {
            answer = answer < count ? answer : count;
            return;
        }

        int newN = 0;
        for(int i=1;i<9;i++) {
            newN = newN*10+N;
            DFS(N,number,count+i, sum+newN);
            DFS(N,number,count+i, sum-newN);
            DFS(N,number,count+i, sum*newN);
            DFS(N,number,count+i, sum/newN);
        }
    }

    public static void main(String[] args) {
        int N = 2;
        int number = 11;
        ExpressN e = new ExpressN();
        System.out.println(e.solution(N,number));
    }
}
