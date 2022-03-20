import java.util.*;
public class EndTalk {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        String prev = "";
        for(int i=0;i<words.length;i++) {
        	String word = words[i];
        	if(prev == "") {
        		prev = word;
        		set.add(word);
        		continue;
        	}
        	// 끝말 맞고 && 처음 쓴 단어인경우
        	if(word.charAt(0) == prev.charAt(prev.length()-1) && !set.contains(word)) {
        		prev = word;
        		set.add(word);
        		continue;
        	} 
        	// 둘중 하나라도 아닐경우
        	else {
        		answer[0] = (i+1)%n == 0?n:(i+1)%n;
        		answer[1] = (i+1)%n == 0?(i+1)/n:((i+1)/n)+1;
        		break;
        	}
        }

        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
		EndTalk et = new EndTalk();
		System.out.println(et.solution(n, words));
	}

}
