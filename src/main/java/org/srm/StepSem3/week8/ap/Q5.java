import java.time.LocalDate;
import java.util.*;
import java.util.function.BiFunction;

abstract class Plan {
    protected String name;
    protected LocalDate start;
    Plan(String name, LocalDate start) {
        this.name = name;
        this.start = start;
    }
    abstract int validityDays();
    LocalDate renewalDate() { return start.plusDays(validityDays()); }
}
class Basic extends Plan {
    Basic(String n, LocalDate d) { super(n, d); }
    int validityDays() { return 30; }
}
class Standard extends Plan {
    Standard(String n, LocalDate d) { super(n, d); }
    int validityDays() { return 90; }
}
class Premium extends Plan {
    Premium(String n, LocalDate d) { super(n, d); }
    int validityDays() { return 365; }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, BiFunction<String, LocalDate, Plan>> types = new HashMap<>();
        types.put("BASIC", Basic::new);
        types.put("STANDARD", Standard::new);
        types.put("PREMIUM", Premium::new);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String t = sc.next();
            String name = sc.next();
            LocalDate start = LocalDate.parse(sc.next());   // YYYY-MM-DD by default
            Plan p = types.get(t).apply(name, start);
            System.out.println(p.name + ": " + p.renewalDate());
        }
    }
}