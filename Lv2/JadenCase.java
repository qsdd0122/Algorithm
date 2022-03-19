
public class JadenCase {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
    	s = s.toLowerCase();
        
        String[] split_s = s.split("");
        boolean flag = true;
        
        for(String ss:split_s) {
        	if(ss.equals(" ")) {
        		sb.append(" ");
        		flag = true;
        		continue;
        	}
        	if(flag == true) {
        		sb.append(ss.toUpperCase());
        		flag = false;
        	} else {
        		sb.append(ss);
        	}
        }
        
        return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = " adgagd  3eagdag  ";
		JadenCase jc = new JadenCase();
		System.out.println(jc.solution(s));
	}

}
