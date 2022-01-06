import java.util.*;
class Solution {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[] posarr = new int[board.length];
        ArrayList<Integer> box = new ArrayList<Integer>();
        for(int i=0;i<posarr.length;i++) posarr[i] = 0;
        int boxnum=0;
        

        for(int i:moves) {
        	if(posarr[i-1] == -1) continue; 
        	
        	while(board[posarr[i-1]][i-1] == 0) {
        		if(posarr[i-1] == board.length-1) break;
        		else posarr[i-1]++;
        	}
        
    		box.add(board[posarr[i-1]][i-1]);		//바구니에 추가
    		boxnum++;
    		
    		if(boxnum > 1 && box.get(boxnum-1) == box.get(boxnum-2)) {  //같으면 터트리기
    			
    			box.remove(boxnum-1); 				
    			box.remove(boxnum-2);
    			
    			answer = answer+2;
    			boxnum = boxnum-2;
    		}
    		
    		if(posarr[i-1]!=board.length-1) posarr[i-1]++;  //
    		else posarr[i-1] = -1;
    		//System.out.println(posarr[i-1]+" "+board[posarr[i-1]][i-1]);
        } 
        return answer;
    }
}