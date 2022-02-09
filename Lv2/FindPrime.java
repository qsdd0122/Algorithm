import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class FindPrime {
	static char[] arr;
	static boolean[] visited;
	static int count;
	static HashSet<Integer> set;
    public static int solution(String numbers) {
        int answer = 0;
        count = 0;
        arr = numbers.toCharArray();
        visited = new boolean[numbers.length()];
        set = new HashSet<>();
        
        for(int i=0; i<numbers.length();i++) {
        	visited[i] = true;
        	DFS(String.valueOf(arr[i]), 0);
        	visited[i] = false;
        }
        

        
        return set.size();
    }
    
    private static void DFS(String s, int depth) {
    	// 재귀 탈출
    	if(depth == arr.length) return;
    	
    	boolean isPrime = isPrime(s);
    	// 소수일 경우 HashSet에 저장
    	if(isPrime) {
    		set.add(Integer.parseInt(s));
    	}
    	
    	// 완전 탐색 재귀
		for(int i=0;i<arr.length;i++) {
			StringBuilder sb = new StringBuilder();
	    	sb.append(s);
    		if(!visited[i]) {
    			visited[i] = true;
    			DFS(sb.append(arr[i]).toString(), depth+1);
    			visited[i] = false;
    		}
		}
    	
    }
    
    // 소수 판별 메소드
    private static boolean isPrime(String s) {
    	
    	int num = Integer.parseInt(s);
    	if(num == 1 || num == 0) return false;
    	for(int i=2;i<=(int)Math.sqrt(num);i++) {
    		if(num%i == 0) return false;
    	}
    	return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1231";
		System.out.println(solution(s));
	}

}
