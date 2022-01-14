import java.util.*;

public class DelPair {

    public static int solution(String s) { 
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);

        	if(!stack.isEmpty()) {
	        	if(stack.peek().equals(c)) {
	        		stack.pop();
	        	} else stack.add(c);
        	}  else stack.add(c); 
        }
        
        return stack.size() == 0 ? 1:0;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcccba";
		
		System.out.println(solution(s));
	}

}
