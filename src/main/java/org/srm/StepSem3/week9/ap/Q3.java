import java.util.*;
import java.util.function.Function;

interface UsesBus {
    double TRANSPORT_FEE = 12000;   // only place the fee is written
}

abstract class Student {
    protected String name;
    Student(String name) { this.name = name; }
    abstract double tuition();
    double totalFee() {
        return tuition() + (this instanceof UsesBus ? UsesBus.TRANSPORT_FEE : 0);
    }
}
class DayScholar extends Student implements UsesBus {
    DayScholar(String n) { super(n); }
    double tuition() { return 40000; }
}
class Hosteller extends Student {
    Hosteller(String n) { super(n); }
    double tuition() { return 40000 + 60000; }
}
class Scholar extends Student implements UsesBus {
    Scholar(String n) { super(n); }
    double tuition() { return 20000; }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Function<String, Student>> types = new HashMap<>();
        types.put("DAY_SCHOLAR", DayScholar::new);
        types.put("HOSTELLER", Hosteller::new);
        types.put("SCHOLAR", Scholar::new);

        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String t = sc.next();
            String name = sc.next();
            Student s = types.get(t).apply(name);
            double f = s.totalFee();
            total += f;
            System.out.println(s.name + ": " + String.format(Locale.US, "%.2f", f));
        }
        System.out.println("Total Collected: " + String.format(Locale.US, "%.2f", total));
    }
}