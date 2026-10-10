import java.util.*;

public class Main {
    static int secondHighest(int[] scores) {
        int highest = -1, second = -1;   // scores are >= 0, so -1 means "not found yet"
        for (int s : scores) {
            if (s > highest) {
                second = highest;
                highest = s;
            } else if (s < highest && s > second) {
                second = s;
            }
            // s == highest is skipped, so duplicates never count
        }
        return second;   // stays -1 if no second distinct score exists
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().replaceAll("[\\[\\]]", "").replace("scores", "").replace("=", "").trim();
        String[] parts = line.split("[,\\s]+");
        int[] scores = new int[parts.length];
        for (int i = 0; i < parts.length; i++) scores[i] = Integer.parseInt(parts[i]);
        System.out.println(secondHighest(scores));
    }
}