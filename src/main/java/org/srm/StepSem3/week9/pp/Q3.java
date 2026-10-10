import java.util.*;
import java.util.function.BiFunction;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;
    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }
    abstract double fine();
}
class Book extends LibraryItem {
    Book(String t, Integer d) { super(t, d); }
    double fine() { return 2.0 * daysLate; }
}
class DVD extends LibraryItem {
    DVD(String t, Integer d) { super(t, d); }
    double fine() { return Math.min(5.0 * daysLate, 50.0); }
}
class Magazine extends LibraryItem {
    Magazine(String t, Integer d) { super(t, d); }
    double fine() { return 1.0 * daysLate; }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, BiFunction<String, Integer, LibraryItem>> types = new HashMap<>();
        types.put("BOOK", Book::new);
        types.put("DVD", DVD::new);
        types.put("MAGAZINE", Magazine::new);

        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String t = sc.next();
            String title = sc.next();
            int days = sc.nextInt();
            LibraryItem item = types.get(t).apply(title, days);
            double f = item.fine();
            total += f;
            System.out.println(item.title + ": " + String.format(Locale.US, "%.2f", f));
        }
        System.out.println("Total Fines: " + String.format(Locale.US, "%.2f", total));
    }
}