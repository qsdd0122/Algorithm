import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GroupWord {
    private static boolean check(String str) {
        Set<Character> set = new HashSet<>();
        set.add(str.charAt(0));
        for(int i=1;i<str.length();i++) {
            char c = str.charAt(i);
            if(c == str.charAt(i-1)) continue;
            if(set.contains(c)) return false;
            set.add(c);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        for(int i=0;i<n;i++) {
            String str = sc.next();
            if(check(str)) answer++;
        }
        System.out.println(answer);
    }
}
