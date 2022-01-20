import java.util.*;
class Solution {
    public static String solution(int[] numbers) {
        String answer = "";
        ArrayList<String> arr = new ArrayList<String>();
        String[] sort_arr = new String[numbers.length];
        for(int i=0;i<numbers.length;i++) {
        	arr.add(String.valueOf(numbers[i]));
        }
        Collections.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return (o1+o2).compareTo(o2+o1);
			}
        	
        });
        for (int index = arr.size()-1; index >= 0; index--) {
        	answer += arr.get(index);
        }
        if(arr.get(arr.size()-1).equals("0")) return "0";
        return answer;
    }
}