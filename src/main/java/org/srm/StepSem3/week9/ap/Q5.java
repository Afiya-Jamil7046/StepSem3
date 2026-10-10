import java.util.*;
import java.util.function.Supplier;

interface SaverMode {
    double units();
    default double saverUnits() { return units() * 0.75; }
}

abstract class Appliance {
    static final double RATE = 8;
    protected double hours;
    abstract double powerWatts();
    void setHours(double h) { hours = h; }
    public double units() { return powerWatts() * hours / 1000; }
    double cost(double units) { return units * RATE; }
}
class Fridge extends Appliance {
    double powerWatts() { return 150; }
}
class AC extends Appliance implements SaverMode {
    double powerWatts() { return 1500; }
}
class TV extends Appliance {
    double powerWatts() { return 100; }
}
class Washer extends Appliance implements SaverMode {
    double powerWatts() { return 500; }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Supplier<Appliance>> types = new HashMap<>();
        types.put("FRIDGE", Fridge::new);
        types.put("AC", AC::new);
        types.put("TV", TV::new);
        types.put("WASHER", Washer::new);

        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            Appliance a = types.get(p[0]).get();
            a.setHours(Double.parseDouble(p[1]));
            boolean saver = p.length > 2 && p[2].equals("SAVER");

            double units;
            if (saver) {
                if (!(a instanceof SaverMode)) {
                    System.out.println(p[0] + ": saver mode not supported");
                    continue;
                }
                units = ((SaverMode) a).saverUnits();
            } else {
                units = a.units();
            }
            double c = a.cost(units);
            total += c;
            System.out.println(p[0] + ": Units=" + String.format(Locale.US, "%.2f", units)
                + " Cost=" + String.format(Locale.US, "%.2f", c));
        }
        System.out.println("Total Cost: " + String.format(Locale.US, "%.2f", total));
    }
}