import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaxHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int total = sc.nextInt();
		int num = 0;
		PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<total; i++) {
			num = sc.nextInt();
			if(num != 0) que.add(num);
			else {
				if(que.isEmpty()) System.out.println(num);
				else {
					System.out.println(que.poll());
				}
			}
		}

	}

}
