import java.util.*;
import java.util.function.BiFunction;

abstract class Employee {
    protected String name;
    protected double salary;
    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    abstract double bonus();
}
class FullTime extends Employee {
    FullTime(String n, double s) { super(n, s); }
    double bonus() { return salary * 0.10; }
}
class PartTime extends Employee {
    PartTime(String n, double s) { super(n, s); }
    double bonus() { return salary * 0.05; }
}
class Intern extends Employee {
    Intern(String n, double s) { super(n, s); }
    double bonus() { return 2000.0; }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, BiFunction<String, Double, Employee>> types = new HashMap<>();
        types.put("FULLTIME", FullTime::new);
        types.put("PARTTIME", PartTime::new);
        types.put("INTERN", Intern::new);

        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String t = sc.next();
            String name = sc.next();
            double sal = sc.nextDouble();
            Employee e = types.get(t).apply(name, sal);
            double b = e.bonus();
            total += b;
            System.out.println(e.name + ": " + String.format(Locale.US, "%.2f", b));
        }
        System.out.println("Total Bonus: " + String.format(Locale.US, "%.2f", total));
    }
}