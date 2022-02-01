import java.util.*;

public class Tuple {
    public static int[] solution(String s) {

        Map<Integer, Integer> map = new HashMap<>();
        String[] arr = s.replaceAll("[{]", "").replaceAll("[}]", "").split(",");
        
        for(String str : arr) {
        	int key = Integer.parseInt(str);
        	map.put(key, map.getOrDefault(key, 0)+1);
        }
        
        int[] answer = new int[map.size()];
        
        for(int key : map.keySet()) {
        	int value = map.get(key);
        	answer[value-1] = key;
        }
        
        int[] reverse_answer = new int[answer.length];
        
        int i=answer.length-1;
        for(int j=0;j<answer.length;j++) {
        	reverse_answer[j] = answer[i];
        	i--;
        }
        return reverse_answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "{{20,111},{111}}";
		System.out.println(solution(s));
	}

}
