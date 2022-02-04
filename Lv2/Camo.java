import java.util.*;
public class Camo {
    public static int solution(String[][] clothes) {

        Map<String, Integer> map = new HashMap<>();

        for(int i=0;i<clothes.length;i++) {
            String type = clothes[i][1];
            map.put(type, map.getOrDefault(type, 0)+1);
        }

        int count = 1;
        for(String type : map.keySet()) {
            count *= map.get(type)+1;
        }

        return count-1;
    }

    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"},{"bluesunglasses", "eyewear"},{"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }
}
