import java.util.Arrays;

public class Lifeboat {

    public static int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int left_pivot = 0;
        int right_pivot = people.length-1;
        
        while(left_pivot < right_pivot) {
        	int small = people[left_pivot];
        	int big = people[right_pivot];
        	if(small+big <= limit) {
        		answer++;
        		left_pivot++;
        		right_pivot--;
        	} else {
        		answer++;
        		right_pivot--;
        	}
        	if(left_pivot == right_pivot) {
        		answer++;
        		break;
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] people = {70,80,50};
		int limit = 100;
		System.out.println(solution(people, limit));

	}

}
