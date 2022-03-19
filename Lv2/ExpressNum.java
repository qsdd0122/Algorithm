
public class ExpressNum {
    public int solution(int n) {
        int answer = 0;
        int sum = 0;
        int k=0;
        for(int i=1;i<=n;i++) {
        	sum = 0;
        	k = i;
        	while(sum <= n) {            	
        		if(sum ==  n) {
        			System.out.println("ok");
        			answer++;
        			break;
        		}
        		sum += k;
        		k++;
        		System.out.println(sum);
            }
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 15;
		ExpressNum en = new ExpressNum();
		System.out.println(en.solution(n));
	}

}
