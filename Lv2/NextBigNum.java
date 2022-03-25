
public class NextBigNum {
    public int solution(int n) {
        int cnt = count1(n);
        
        while(true) {
        	n += 1;
        	if(count1(n) == cnt) break;
        }

        return n;
    }
    
    private int count1(int n) {
    	int count = 1;
    	while(n/2 != 0) {
    		if(n%2 == 1) count++;
    		n /= 2;
    	}
    	return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 78;
		NextBigNum nb = new NextBigNum();
		System.out.println(nb.solution(n));
	}

}
