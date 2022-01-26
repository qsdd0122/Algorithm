import java.util.*;

public class Nara124 {
	
	public static String solution(int n) {
	    String[] numbers = {"4", "1", "2"};
	    String answer = "";

	    int num = n;

	    while(num > 0){
	        int remainder = num % 3;
	        num /= 3;   
	        if(remainder == 0) num--;
	        answer = numbers[remainder] + answer;
	    }
	    
	    return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 12;
		System.out.println(solution(n));
	}

}
