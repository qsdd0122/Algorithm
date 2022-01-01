
public class TargetNumber {
	static int count;
    public static int solution(int[] numbers, int target) {
        DFS(numbers,target,0,0);
        
        return count;
    }
    
    public static void DFS(int[] numbers, int target, int depth, int result) {
    	
    	if(result == target && depth == numbers.length) {
    		count++;
    	} else if(depth != numbers.length){
    		DFS(numbers, target, depth+1, result + numbers[depth]);
        	DFS(numbers, target, depth+1, result - numbers[depth]);
    	}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		
		System.out.println(solution(numbers,target));
	}

}
