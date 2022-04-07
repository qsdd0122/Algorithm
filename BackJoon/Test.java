import java.util.*;

public class Test {

    private static class Loc {
        int start;
        int end;
        public Loc(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        int start,end;
        List<Loc> list = new ArrayList<>();
        for(int i=0;i<num;i++) {

            String str = sc.nextLine();
            String[] split_str = str.split(" ");
            start = Integer.parseInt(split_str[0]);
            end = Integer.parseInt(split_str[1]);
            list.add(new Loc(start,end));
        }

        Collections.sort(list, new Comparator<Loc>() {
            @Override
            public int compare(Loc o1, Loc o2) {
                return o1.start-o2.start;
            }
        });
        int ans_start = list.get(0).start;
        int ans_end = list.get(0).end;
        for(int i=1;i<list.size();i++) {
            if(ans_end >= list.get(i).start) {
                ans_end = ans_end>=list.get(i).end?ans_end:list.get(i).end;
            } else {
                System.out.println(ans_start+" "+ans_end);
                ans_start = list.get(i).start;
                ans_end = list.get(i).end;
            }
        }
        System.out.println(ans_start+" "+ans_end);
    }
}