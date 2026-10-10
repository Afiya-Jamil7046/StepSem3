import java.util.*;
import java.util.function.Function;

abstract class Vehicle {
    protected int hours;
    Vehicle(int hours) { this.hours = hours; }
    abstract double charge();
}
class Bike extends Vehicle {
    Bike(int h) { super(h); }
    double charge() { return 10.0 * hours; }
}
class Car extends Vehicle {
    Car(int h) { super(h); }
    double charge() { return 30.0 + 20.0 * (hours - 1); }
}
class Truck extends Vehicle {
    Truck(int h) { super(h); }
    double charge() { return Math.max(100.0, 50.0 * hours); }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Function<Integer, Vehicle>> types = new HashMap<>();
        types.put("BIKE", Bike::new);
        types.put("CAR", Car::new);
        types.put("TRUCK", Truck::new);

        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String t = sc.next();
            int h = sc.nextInt();
            double c = types.get(t).apply(h).charge();
            total += c;
            System.out.println(t + ": " + String.format(Locale.US, "%.2f", c));
        }
        System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
    }
}