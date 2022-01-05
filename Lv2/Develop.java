class Solution {
	public static String solution(int[] numbers, String hand) {
        String answer = "";
        
        int[][] keypad = {{1,4,7,10},{2,5,8,11},{3,6,9,12}};
        int current_L = 10;
        int current_R = 12;
        
        for(int i:numbers) {
        	if(i == 0) i =11;
        	if(i == 1 || i==4 || i==7) {
        		answer += "L";
        		current_L = i;
        		System.out.println("L "+current_L+" "+current_R);
        	}
        	else if(i == 3 || i==6 || i==9) {
        		answer += "R";
        		current_R = i;
        		System.out.println("R "+current_L+" "+current_R);
        	}
        	else {
        		// /가 위아래 %가 왼오
        		
        		int L_x = Math.abs((current_L-1)/3 - ((i-1)/3));
        		int L_y = Math.abs((current_L-1)%3 - ((i-1)%3));
        		int len_L = L_x+L_y;
        		int R_x = Math.abs((current_R-1)/3 - ((i-1)/3));
        		int R_y = Math.abs((current_R-1)%3 - ((i-1)%3));
        		int len_R = R_x+R_y;
        		
        		if(len_L>len_R) {
        			answer += "R";
        			current_R = i;
            		System.out.println("R "+current_L+" "+current_R);
        		}
        		else if(len_L<len_R) {
        			answer += "L";
        			current_L = i;
            		System.out.println("L "+current_L+" "+current_R);
        		}
        		else {
        			if(hand.equals("left")==true) {
        				answer += "L";
            			current_L = i;
                		System.out.println("L "+current_L+" "+current_R);
        			}
        			else {
        				answer += "R";
            			current_R = i;
                		System.out.println("R "+current_L+" "+current_R);
        			}
        		}
       
        	}
        }
        return answer;
    }
}