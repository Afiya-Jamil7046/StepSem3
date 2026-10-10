import java.util.*;

abstract class Room {
    protected double units;
    protected int occupants;
    Room(double units, int occupants) {
        this.units = units;
        this.occupants = occupants;
    }
    abstract double bill();
}
class SingleRoom extends Room {
    SingleRoom(double u, int o) { super(u, o); }
    double bill() { return 8.0 * units; }
}
class SharedRoom extends Room {
    SharedRoom(double u, int o) { super(u, o); }
    double bill() { return 6.0 * units / occupants; }
}
class ACRoom extends Room {
    ACRoom(double u, int o) { super(u, o); }
    double bill() { return 10.0 * units + 200.0; }
}

interface RoomFactory { Room create(double units, int occupants); }

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, RoomFactory> types = new HashMap<>();
        types.put("SINGLE", SingleRoom::new);
        types.put("SHARED", SharedRoom::new);
        types.put("AC", ACRoom::new);

        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            double units = Double.parseDouble(p[1]);
            int occ = (p.length > 2) ? Integer.parseInt(p[2]) : 1;
            double b = types.get(p[0]).create(units, occ).bill();
            total += b;
            System.out.println(p[0] + ": " + String.format(Locale.US, "%.2f", b));
        }
        System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
    }
}