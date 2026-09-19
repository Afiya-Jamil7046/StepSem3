class Scorecard {
    private final boolean[] results;
    private int recorded = 0;

    Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
    }

    void recordAnswer(boolean correct) {
        if (recorded >= results.length) {
            System.out.println("Rejected: all answers already recorded");
            return;
        }
        results[recorded] = correct;
        recorded++;
    }

    int getScore() {
        int score = 0;
        for (int i = 0; i < recorded; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }
}

public class Main {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        sc.recordAnswer(true); // extra answer, gets rejected

        System.out.println("Score: " + sc.getScore());
    }
}