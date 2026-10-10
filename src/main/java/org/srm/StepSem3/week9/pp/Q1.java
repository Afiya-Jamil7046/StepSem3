import java.util.*;
import java.util.function.BiFunction;

abstract class Plot {
    protected String owner;
    Plot(String owner) { this.owner = owner; }
    abstract double area();
}
class Circle extends Plot {
    double r;
    Circle(String o, double[] d) { super(o); r = d[0]; }
    double area() { return Math.PI * r * r; }
}
class Rectangle extends Plot {
    double l, w;
    Rectangle(String o, double[] d) { super(o); l = d[0]; w = d[1]; }
    double area() { return l * w; }
}
class Triangle extends Plot {
    double b, h;
    Triangle(String o, double[] d) { super(o); b = d[0]; h = d[1]; }
    double area() { return 0.5 * b * h; }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, BiFunction<String, double[], Plot>> types = new HashMap<>();
        types.put("CIRCLE", Circle::new);
        types.put("RECTANGLE", Rectangle::new);
        types.put("TRIANGLE", Triangle::new);

        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            double[] d = new double[p.length - 2];
            for (int j = 2; j < p.length; j++) d[j - 2] = Double.parseDouble(p[j]);
            Plot plot = types.get(p[0]).apply(p[1], d);
            double a = plot.area();
            total += a;
            System.out.println(plot.owner + " (" + p[0] + "): " + String.format(Locale.US, "%.2f", a));
        }
        System.out.println("Total Area: " + String.format(Locale.US, "%.2f", total));
    }
}