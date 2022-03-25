import java.util.*;
public class Rotate {
    public int solution(String s) {
        int answer = 0;
       
        for(int i=0;i<s.length();i++) {
        	if(checkRight(s)) {
        		System.out.println(checkRight(s));
        		answer++;
        	}
        	s = s.substring(1,s.length()) + s.substring(0,1);
        	System.out.println(s);
        }
        
        return answer;
    }
    
    private boolean checkRight(String s) {
    	Stack<Character> stack = new Stack<>();
    	for(char c:s.toCharArray()) {
        	if(!stack.isEmpty()) {
        		char top = stack.peek();
        		if((top == '[' && c == ']') || (top == '{' && c == '}') || (top == '(' && c == ')'))
        			stack.pop();
        	}
        	else stack.add(c);
        }
    	if(stack.isEmpty()) return true;
    	return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "[)(]";
		Rotate rotate = new Rotate();
		System.out.println(rotate.solution(s));
	}

}
