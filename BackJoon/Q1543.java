import java.util.Scanner;

public class Q1543 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String doc = sc.nextLine();
        String word = sc.nextLine();
        int answer = 0;
        while(true) {
            if(doc.contains(word)) {
                doc = doc.replaceFirst(word, ",");
                answer++;
            } else break;
        }
        System.out.println(answer);
    }
}
