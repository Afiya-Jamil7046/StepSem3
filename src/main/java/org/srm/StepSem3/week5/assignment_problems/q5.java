import java.util.Arrays;

public class Q5 {

    static class Player implements Comparable<Player> {
        String name;
        int matchesPlayed;
        double battingAverage;
        boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        double fantasyPoints() {
            return battingAverage;
        }

        @Override
        public int compareTo(Player other) {
            // descending order by fantasy points
            return Double.compare(other.fantasyPoints(), this.fantasyPoints());
        }
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    static String draftAndRank(Player[] players) {
        Player[] pool = new Player[players.length];
        int count = 0;

        for (Player p : players) {
            boolean qualifies = isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured);
            if (qualifies) {
                pool[count++] = p;
            }
        }

        Player[] draftable = Arrays.copyOf(pool, count);
        Arrays.sort(draftable);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            if (i > 0) result.append(" | ");
            result.append(i + 1).append(". ").append(draftable[i].name);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(players));
        // Expected: 1. Rahul | 2. Virat | 3. Dev
    }
}