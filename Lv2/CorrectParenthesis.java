import java.util.Stack;

public class CorrectParenthesis {
	
    static boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        
        for(char p : s.toCharArray()) {
        	
        	if(stack.size() == 0 && p == ')') {
        		return false;
        	}
        	
        	if(p == '(') stack.add(p);
        	else {
        		stack.pop();
        	}

        }
        
        if(stack.size() != 0) return false;
 
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "()()";
		System.out.println(solution(s));
	}

}
