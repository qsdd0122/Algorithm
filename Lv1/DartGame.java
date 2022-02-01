import java.util.*;
class Solution {
    public static int solution(String dartResult) {
        int answer = 0;
        
        char[] arr = dartResult.toCharArray();
        int[] cal_arr = {0,0,0};
        int index=-1;
        boolean isTen=false;
        //for(int i=0;i<arr.length;i++)System.out.print(arr[i]+" ");
        for(int i=0;i<arr.length;i++) {
        	
        	if(arr[i] == 'S') {
        		if(isTen) {
        			cal_arr[index] = 10;
        			isTen = false;
        		}
        		else cal_arr[index] = Character.getNumericValue(arr[i-1]);
        	}
        	else if(arr[i] == 'D') {
        		if(isTen) {
        			isTen = false;
        			cal_arr[index] = 100;
        		}
        		else cal_arr[index] = (int) Math.pow(Character.getNumericValue(arr[i-1]), 2);
        	}
        	else if(arr[i] == 'T') {
        		if(isTen) {
        			isTen = false;
        			cal_arr[index] = 1000;
        		}
        		else cal_arr[index] = (int) Math.pow(Character.getNumericValue(arr[i-1]), 3);
        	}
        	else if(arr[i] == '#') cal_arr[index] *= -1;
        	else if(arr[i] == '*') {
        		cal_arr[index] *= 2;
        		if(index != 0) cal_arr[index-1] *=2;
        	}
        	else if(arr[i] == '1' && arr[i+1] == '0') {
        		index++;
        		i++;
        		isTen = true;
        		
        	}
        	else index++;
        	
        }
        for(int i=0;i<cal_arr.length;i++) answer += cal_arr[i];
        
        return answer;
    }
}