import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String word = sc.next();
            String rev = new StringBuilder(word).reverse().toString();
            if (word.equals(rev)) System.out.println(rev + " - palindrome");
            else System.out.println(rev + " - not a palindrome");
        }
    }
}