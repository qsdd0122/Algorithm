
public class ChangeBracket {
    private static String solution(String p) {
    	if(p.equals("")) return "";
        
        char[] arr = p.toCharArray();
        int left=0;
        int right=0;
        String[] rtn_arr = new String[2];
        
        StringBuilder sb = new StringBuilder();
    	StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        
        
        for(int index=0;index<arr.length;index++) {
        	if(arr[index] == '(') left++;
        	else right++;
        	
        	if(left == right) {
        		u.append(p.substring(0,index+1));
        		v.append(p.substring(index+1));
        		break;
        	}
        }

        // u가 올바른 괄호 문자열이면
        if(checkIsCorrect(u.toString())) {
        	return u.append(solution(v.toString())).toString();
        }
        return sb.append(changeU(u.toString(),v.toString())).toString();
    }
    
    //u가 올바른 괄호 문자열인지 판별
    private static Boolean checkIsCorrect(String U) {
    	int check = 0;
    	char[] arr = U.toCharArray();
    	for(char c : arr) {
    		if(check<0) return false;
    		if(c == '(') check++;
    		else check--;
    	}
    	return true;
    }
    
    private static String changeU(String U, String V) {
    	String temp = "(";
    	
    	String rtn = solution(V);

    	//앞뒤 자르기
    	temp += rtn +")";
    	U = U.substring(1, U.length()-1);
    	
    	char[] c_arr = U.toCharArray();
    	for(int i=0; i<c_arr.length;i++) {
    		if(c_arr[i] == '(') temp += ")";
    		else temp += "(";
    	}
    	return temp;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String p = "()))((()";
		//solution(p);
		System.out.println(solution(p));
	}

}
