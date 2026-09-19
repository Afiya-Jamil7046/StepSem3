class PiggyBank {
    private int savings;
    private final String id;

    PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    void deposit(int amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected: amount must be positive");
            return;
        }
        savings += amount;
    }

    void withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("Withdraw rejected: amount must be positive");
            return;
        }
        if (amount > savings) {
            System.out.println("Withdraw rejected: not enough savings");
            return;
        }
        savings -= amount;
    }

    int getSavings() {
        return savings;
    }

    String getId() {
        return id;
    }
}

public class Main {
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        System.out.println("savings = " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("savings = " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("savings = " + pb.getSavings());
    }
}