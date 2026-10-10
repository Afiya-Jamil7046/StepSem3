import java.util.*;

public class Main {
    static int[] busiestRow(int[][] grid) {
        int bestRow = 0, bestTotal = -1;
        for (int i = 0; i < grid.length; i++) {
            int total = 0;
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
            }
            if (total > bestTotal) {   // strictly larger, so ties keep the earlier row
                bestTotal = total;
                bestRow = i;
            }
        }
        return new int[]{bestRow, bestTotal};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[]> rows = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) sb.append(sc.nextLine()).append(' ');
        // split on "]" so each chunk is one row, ignoring brackets and "grid ="
        for (String chunk : sb.toString().split("\\]")) {
            String cleaned = chunk.replaceAll("[^0-9,\\s]", " ").trim();
            if (cleaned.isEmpty()) continue;
            String[] parts = cleaned.split("[,\\s]+");
            int[] row = new int[parts.length];
            for (int i = 0; i < parts.length; i++) row[i] = Integer.parseInt(parts[i]);
            rows.add(row);
        }
        int[][] grid = rows.toArray(new