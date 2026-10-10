import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().replaceAll("[\\[\\]]", "").trim();
        int even = 0, odd = 0;
        for (String s : line.split("[,\\s]+")) {
            if (s.isEmpty()) continue;
            int x = Integer.parseInt(s);
            if (x % 2 == 0) even++;
            else odd++;
        }
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}