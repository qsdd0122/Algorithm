import java.util.*;   
class Solution {
    public static ArrayList<Integer> solution(int brown, int yellow) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int x = 0;
        int y = 0;
        // 2x+2y = brown, x*y = yellow
        for(int i=1;i<=yellow;i++) {
        	if(yellow%i == 0) {
        		x = i;
        		y = yellow/i;
        		if(2*x + 2*y +4== brown && x>=y) {
        			break;
        		}
        		else {
        			x=0;
        			y=0;
        		}
        	}
        	System.out.println("--------");
        }
        arr.add(x+2);
        arr.add(y+2);
        return arr;
    }
}