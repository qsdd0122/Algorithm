import java.util.*;
class Lotto {
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int rank = 7;
        ArrayList<Integer> lot_list = new ArrayList<Integer>();
        for(int i:lottos) {
        	if(i != 0) lot_list.add(i);
        }
        
        for(int i:win_nums) {
        	if(lot_list.contains(i)) rank--;
        }
        
        answer[0] = rank-(6-lot_list.size());
        answer[1] = rank;
        if(answer[0] == 7) answer[0] = 6;
        if(answer[1] == 7) answer[1] = 6;

        return answer;
    }
}