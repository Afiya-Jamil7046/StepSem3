import java.util.*;
import java.util.function.Function;

abstract class Booking {
    static final double BOOKING_FEE = 50;   // the only place the fee is written
    protected double distance;
    Booking(double distance) { this.distance = distance; }
    abstract double baseFare();
    final double totalFare() { return baseFare() + BOOKING_FEE; }
}
class Bus extends Booking {
    Bus(Double d) { super(d); }
    double baseFare() { return 2 * distance; }
}
class Train extends Booking {
    Train(Double d) { super(d); }
    double baseFare() { return 1.5 * distance; }
}
class Flight extends Booking {
    Flight(Double d) { super(d); }
    double baseFare() { return 2500 + 4 * distance; }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Function<Double, Booking>> types = new HashMap<>();
        types.put("BUS", Bus::new);
        types.put("TRAIN", Train::new);
        types.put("FLIGHT", Flight::new);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String m = sc.next();
            double d = sc.nextDouble();
            double t = types.get(m).apply(d).totalFare();
            System.out.println(m + ": " + String.format(Locale.US, "%.2f", t));
        }
    }
}