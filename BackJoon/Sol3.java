import java.util.HashMap;
import java.util.Map;

public class Sol3 {
    public long[] solution(String[] words) {
        long[] answer = new long[words.length];

        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i< words.length;i++) {
            String word = words[i];
            int round = i+1;

            if(!map.containsKey(word)) {
                map.put(word,round);
                answer[i] = round;
            }
            else {
                answer[i] = map.get(word);
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        String[] words = {"one", "one", "two", "one"};
        Sol3 sol3 = new Sol3();
        System.out.println(sol3.solution(words));
    }
}
