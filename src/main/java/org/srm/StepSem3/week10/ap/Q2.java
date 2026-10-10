import java.util.*;

public class Main {
    static int[] attendanceSummary(int[] days) {
        int present = 0, current = 0, longest = 0;
        for (int d : days) {
            if (d == 1) {
                present++;
                current++;
                if (current > longest) longest = current;
            } else {
                current = 0;   // a 0 breaks the streak
            }
        }
        return new int[]{present, longest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().replaceAll("[^0-9,\\s]", " ").trim();
        String[] parts = line.split("[,\\s]+");
        int[] days = new int[parts.length];
        for (int i = 0; i < parts.length; i++) days[i] = Integer.parseInt(parts[i]);
        int[] r = attendanceSummary(days);
        System.out.println("Present: " + r[0] + ", Longest streak: " + r[1]);
    }
}