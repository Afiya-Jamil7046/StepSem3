import java.util.*;

class Student {
    private String name;
    private int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double average() {
        int sum = 0;
        for (int m : marks) sum += m;
        return (double) sum / marks.length;
    }

    String grade() {
        double avg = average();
        if (avg >= 90) return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 60) return "C";
        else if (avg >= 40) return "D";
        else return "F";
    }

    void print() {
        System.out.println(name.toUpperCase() + ": Average "
            + String.format(Locale.US, "%.1f", average()) + ", Grade " + grade());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            int open = line.indexOf('[');
            int close = line.indexOf(']');
            String name = line.substring(0, open).trim();
            String[] parts = line.substring(open + 1, close).split(",");
            int[] marks = new int[parts.length];
            for (int i = 0; i < parts.length; i++) marks[i] = Integer.parseInt(parts[i].trim());
            new Student(name, marks).print();
        }
    }
}