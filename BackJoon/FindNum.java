import java.util.*;
public class FindNum {
	private static int binarySearch(int num, int[] A) {
		int start= 0; 
		int end = A.length-1; 
		int mid = (end+start)/2;
		
		while(end-start>=0) {
			if(A[mid] == num) return 1;
			else if(A[mid] > num) {
				end = mid-1;
				mid = (end+start)/2;
			} else {
				start = mid+1;
				mid = (end+start)/2;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
 		for(int i=0;i<N;i++) {
			A[i] = sc.nextInt();
		}
 		Arrays.sort(A);

 		int M = sc.nextInt();
 		for(int i=0;i<M;i++) {
 			System.out.println(binarySearch(sc.nextInt(),A));
 		}
 		
	}

}
