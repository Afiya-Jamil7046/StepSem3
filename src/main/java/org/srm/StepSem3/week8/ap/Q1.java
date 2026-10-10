import java.util.*;
import java.util.function.Function;

abstract class Customer {
    protected double amount;
    Customer(double amount) { this.amount = amount; }
    abstract double finalAmount();
}
class Student extends Customer {
    Student(double a) { super(a); }
    double finalAmount() { return amount * 0.90; }
}
class Staff extends Customer {
    Staff(double a) { super(a); }
    double finalAmount() { return amount * 0.95; }
}
class Guest extends Customer {
    Guest(double a) { super(a); }
    double finalAmount() { return amount + 10; }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Function<Double, Customer>> types = new HashMap<>();
        types.put("STUDENT", Student::new);
        types.put("STAFF", Staff::new);
        types.put("GUEST", Guest::new);

        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String t = sc.next();
            double amt = sc.nextDouble();
            double res = types.get(t).apply(amt).finalAmount();
            total += res;
            System.out.println(t + ": " + String.format(Locale.US, "%.2f", res));
        }
        System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
    }
}