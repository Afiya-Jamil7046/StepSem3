import java.util.*;
import java.util.function.Function;

abstract class Ticket {
    static final double CONVENIENCE_FEE = 20;   // only place the fee is written
    protected int count;
    Ticket(int count) { this.count = count; }
    abstract double price();
    final double amount() { return count * (price() + CONVENIENCE_FEE); }
}
class Regular extends Ticket {
    Regular(Integer c) { super(c); }
    double price() { return 150; }
}
class Premium extends Ticket {
    Premium(Integer c) { super(c); }
    double price() { return 250; }
}
class Recliner extends Ticket {
    Recliner(Integer c) { super(c); }
    double price() { return 400; }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Function<Integer, Ticket>> types = new HashMap<>();
        types.put("REGULAR", Regular::new);
        types.put("PREMIUM", Premium::new);
        types.put("RECLINER", Recliner::new);

        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i