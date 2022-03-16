
public class MaxandMin {
	
    public static String solution(String s) {
        
        String[] s_arr = s.split(" ");
        int max = Integer.parseInt(s_arr[0]);
        int min = Integer.parseInt(s_arr[0]);
        int num;
        for(int i=1;i<s_arr.length;i++) {
        	num = Integer.parseInt(s_arr[i]);
        	
        	// max
        	if(max < num) max = num;
        	// min
        	if(min > num) min = num;
        	
        }
        
        return min+" "+max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1 2 3 4";
		System.out.println(solution(s));
	}

}
