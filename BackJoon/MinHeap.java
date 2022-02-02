import java.util.*;
public class MinHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			int num = sc.nextInt();
			if(num != 0) heap.add(num);
			else {
				if(heap.isEmpty()) System.out.println(0);
				else System.out.println(heap.poll());
			}
		}
	}

}
