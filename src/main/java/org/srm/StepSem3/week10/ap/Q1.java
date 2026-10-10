import java.util.*;

public class Main {
    // first index where scores[i] >= target (returns n if none)
    static int lowerBound(int[] scores, int target) {
        int lo = 0, hi = scores.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (scores[mid] >= target) hi = mid;   // keep looking left, even on a match
            else lo = mid + 1;
        }
        return lo;
    }

    // first index where scores[i] > target (returns n if none)
    static int upperBound(int[] scores, int target) {
        int lo = 0, hi = scores.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (scores[mid] > target) hi = mid;
            else lo = mid + 1;                     // equal values are pushed past
        }
        return lo;
    }

    static int countInBand(int[] scores, int low, int high) {
        return upperBound(scores, high) - lowerBound(scores, low);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().replaceAll("[^0-9,\\s]", " ").trim();
        String[] parts = line.split("[,\\s]+");
        int[] scores = new int[parts.length];
        for (int i = 0; i < parts.length; i++) scores[i] = Integer.parseInt(parts[i]);
        int low = sc.nextInt();
        int high = sc.nextInt();
        System.out.println(countInBand(scores, low, high));
    }
}