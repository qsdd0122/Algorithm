import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Q1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Queue<Integer> heap = new PriorityQueue<>();
        for(int i=0;i<num;i++) {
            int next = sc.nextInt();
            heap.add(next);
        }
        int sum = 0;
        while(heap.size()>1) {
            int first = heap.poll();
            int second = heap.poll();
            sum += first+second;
            heap.add(first+second);
        }
        System.out.println(sum);
    }
}