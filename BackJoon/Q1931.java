import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            list.add(new int[]{start,end});
        }

        // 빨리 끝나는 순으로 정렬
        Collections.sort(list,(int[] arr1, int[] arr2)-> {
            if(arr1[1] == arr2[1]) return arr1[0] - arr2[0];
            return arr1[1]-arr2[1];
        });

        int start = 0;
        int end = 0;
        for(int i=0;i<list.size();i++) {
            int temp_start = list.get(i)[0];
            int temp_end = list.get(i)[1];

            if(end<=temp_start) {
                answer++;
                start = temp_start;
                end = temp_end;
            }
        }
        System.out.println(answer);
    }
}
