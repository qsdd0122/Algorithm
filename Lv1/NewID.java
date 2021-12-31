import java.util.*;
class NewID {
	public static String solution(String new_id) {

        String answer = new_id;
        
        //1�ܰ�
        answer = answer.toLowerCase();
        //2�ܰ�
        answer = answer.replaceAll("[^0-9a-z-_.]", "");
        //3�ܰ�
        answer = answer.replaceAll("[.]{2,}", ".");
        //4�ܰ�
        answer = answer.replaceAll("[.]$", "");
        answer = answer.replaceAll("^[.]", "");
        //5�ܰ�
        if(answer.isEmpty() == true) answer = "a"; 
        
        //6�ܰ�
        if(answer.length() >=16) answer = answer.substring(0, 15);
		answer = answer.replaceAll("[.]$", "");
        
        //7�ܰ�
		if(answer.length() < 3) {
			String last = answer.substring(answer.length()-1);
			while(answer.length()<3) answer = answer.concat(last);	
		}

        return answer;
    }
}