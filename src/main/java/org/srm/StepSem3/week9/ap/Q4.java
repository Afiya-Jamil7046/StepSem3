import java.util.*;
import java.util.function.Supplier;

interface NightService {
    default double nightFare(double fare) { return fare * 1.20; }
}

abstract class Cab {
    static final double MIN_FARE = 100;   // shared rule, written once
    abstract double ratePerKm();
    double fare(double km) { return Math.max(km * ratePerKm(), MIN_FARE); }
}
class Mini extends Cab {
    double ratePerKm() { return 10; }
}
class Sedan extends Cab implements NightService {
    double ratePerKm() { return 14; }
}
class SUV extends Cab implements NightService {
    double ratePerKm() { return 18; }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Supplier<Cab>> types = new HashMap<>();
        types.put("MINI", Mini::new);
        types.put("SEDAN", Sedan::new);
        types.put("SUV", SUV::new);

        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String t = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            Cab cab = types.get(t).get();
            double f = cab.fare(km);
            if (time.equals("NIGHT")) {
                if (cab instanceof NightService) {
                    f = ((NightService) cab).nightFare(f);
                } else {
                    System.out.println(t + ": night service not available");
                    continue;
                }
            }
            total += f;
            System.out.println(t + ": " + String.format(Locale.US, "%.2f", f));
        }
        System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
    }
}