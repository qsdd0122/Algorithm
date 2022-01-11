
public class FineSquare {
    public static long solution(int w, int h) {
        int min = w > h ? h : w;
        int num = 0;
        for(int i=1;i<=min;i++) {
        	if(w%i == 0 && h%i == 0) {
        		num = i;
        	}
        }

        int disabled = ((w/num) + (h/num)-1)*num;
        
        return (long)w*h-disabled;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int w = 2;
		int h = 2;
		System.out.println(solution(w,h));
	}

}
