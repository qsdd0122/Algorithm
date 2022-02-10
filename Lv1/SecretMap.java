class Solution {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0;i<n;i++) answer[i] ="";
        int[][] map1 = new int[n][n];
        int[][] map2 = new int[n][n];

       
        for(int i=0;i<n;i++) {
        	int k = arr1[i];
        	int a = n-1;
        	while(true) {
        		if(k == 0) break;
        		if(k/2 == 0) {
        			map1[i][a] = 1;
        			break;
        		}
        		map1[i][a] = k%2;
        		k /=2;
        		a--;

        	}
        }
        
        for(int i=0;i<n;i++) {
        	int k = arr2[i];
        	int a = n-1;
        	while(true) {
        		if(k == 0) break;
        		if(k/2 == 0) {
        			map2[i][a] = 1;
        			break;
        		}
        		map2[i][a] = k%2;
        		k /=2;
        		a--;
        	}
        }
        for(int i=0;i<n;i++)System.out.println(map1[0][i]);
        
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		if(map1[i][j] == 1 || map2[i][j] == 1) answer[i] += "#";
        		else answer[i] += " ";
        	}
        }
        return answer;
    }
}