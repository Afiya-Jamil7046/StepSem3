class TrafficLight {
    private String color = "RED";
    private final String id;

    TrafficLight(String id) {
        this.id = id;
    }

    String next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else {
            color = "RED";
        }
        return color;
    }

    String getColor() {
        return color;
    }

    String getId() {
        return id;
    }
}

public class Main {
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");

        System.out.println(t.getColor()); // RED
        System.out.println(t.next());     // GREEN
        System.out.println(t.next());     // YELLOW
        System.out.println(t.next());     // RED
        System.out.println(t.next());     // GREEN, cycles forever
    }
}