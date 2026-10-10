import java.util.*;
import java.util.function.Function;

abstract class Connection {
    protected double units;
    Connection(double units) { this.units = units; }
    abstract double bill();
}
class Home extends Connection {
    Home(Double u) { super(u); }
    double bill() {
        if (units <= 100) return units * 5;
        return 100 * 5 + (units - 100) * 7;
    }
}
class Shop extends Connection {
    Shop(Double u) { super(u); }
    double bill() { return units * 8 + 100; }
}
class Factory extends Connection {
    Factory(Double u) { super(u); }
    double bill() { return Math.max(units * 6, 1000); }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Function<Double, Connection>> types = new HashMap<>();
        types.put("HOME", Home::new);
        types.put("SHOP", Shop::new);
        types.put("FACTORY", Factory::new);

        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String t = sc.next();
            double units = sc.nextDouble();
            double b = types.get(t).apply(units).bill();
            total += b;
            System.out.println(t + ": " + String.format(Locale.US, "%.2f", b));
        }
        System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
    }
}