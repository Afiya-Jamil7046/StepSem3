import java.util.*;
import java.util.function.BiFunction;

interface Insurable {
    double getDeclaredValue();
    default double insurance() { return 0.02 * getDeclaredValue(); }
}

abstract class Parcel {
    protected double weight, declaredValue;
    Parcel(double w, double v) { weight = w; declaredValue = v; }
    public double getDeclaredValue() { return declaredValue; }
    abstract double charge();
}
class Standard extends Parcel {
    Standard(Double w, Double v) { super(w, v); }
    double charge() { return 40 + 10 * weight; }
}
class Express extends Parcel implements Insurable {
    Express(Double w, Double v) { super(w, v); }
    double charge() { return 80 + 15 * weight; }
}
class Fragile extends Standard implements Insurable {
    Fragile(Double w, Double v) { super(w, v); }
    double charge() { return super.charge() + 50; }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, BiFunction<Double, Double, Parcel>> types = new HashMap<>();
        types.put("STANDARD", Standard::new);
        types.put("EXPRESS", Express::new);
        types.put("FRAGILE", Fragile::new);

        int n = sc.nextInt();
        double grand = 0;
        for (int i = 0; i < n; i++) {
            String t = sc.next();
            double w = sc.nextDouble(), v = sc.nextDouble();
            Parcel p = types.get(t).apply(w, v);
            double c = p.charge();
            double ins = (p instanceof Insurable) ? ((Insurable) p).insurance() : 0;
            double tot = c + ins;
            grand += tot;
            System.out.println(t + ": Charge=" + String.format(Locale.US, "%.2f", c)
                + " Insurance=" + String.format(Locale.US, "%.2f", ins)
                + " Total=" + String.format(Locale.US, "%.2f", tot));
        }
        System.out.println("Grand Total: " + String.format(Locale.US, "%.2f", grand));
    }
}