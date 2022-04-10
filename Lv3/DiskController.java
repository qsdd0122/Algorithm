import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class DiskController {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        Arrays.sort(jobs, (arr1,arr2)-> arr1[0] - arr2[0]);
        Queue<int[]> heap = new PriorityQueue<>((arr1, arr2) -> arr1[1] - arr2[1]);
        int sum = 0;
        int done = 0;
        int now=0;
        while (done < jobs.length){
            for(int j=now;j<jobs.length;j++) {
                if(jobs[j][0] <= time) {
                    heap.add(jobs[j]);
                    now = j+1;
                }
                else break;
            }
            if(heap.size() == 0) {
                time = jobs[now][0];
                continue;
            } else {
                int[] peek = heap.poll();
                sum += time + peek[1] - peek[0];
                time += peek[1];
                done++;
            }

        }

        return sum/ jobs.length;
    }

    public static void main(String[] args) {
        int[][] jobs = {{0, 2}, {3, 3}, {4, 2}};
        DiskController dc = new DiskController();
        System.out.println(dc.solution(jobs));
    }
}
