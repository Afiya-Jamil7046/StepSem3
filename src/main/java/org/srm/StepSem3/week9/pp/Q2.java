import java.util.*;
import java.util.function.BiFunction;

abstract class Staff {
    protected String name;
    Staff(String name) { this.name = name; }
    abstract double pay();
}
class FullTime extends Staff {
    double salary;
    FullTime(String n, double[] d) { super(n); salary = d[0]; }
    double pay() { return salary; }
}
class Hourly extends Staff {
    double hours, rate;
    Hourly(String n, double[] d) { super(n); hours = d[0]; rate = d[1]; }
    double pay() {
        if (hours <= 40) return hours * rate;
        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}
class Intern extends Staff {
    double stipend;
    Intern(String n, double[] d) { super(n); stipend = d[0]; }
    double pay() { return stipend; }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, BiFunction<String, double[], Staff>> types = new HashMap<>();
        types.put("FULLTIME", FullTime::new);
        types.put("HOURLY", Hourly::new);
        types.put("INTERN", Intern::new);

        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            double[] d = new double[p.length - 2];
            for (int j = 2; j < p.length; j++) d[j - 2] = Double.parseDouble(p[j]);
            Staff s = types.get(p[0]).apply(p[1], d);
            double pay = s.pay();
            total += pay;
            System.out.println(s.name + ": " + String.format(Locale.US, "%.2f", pay));
        }
        System.out.println("Total Payroll: " + String.format(Locale.US, "%.2f", total));
    }
}