class AttendanceSheet {
    private String[] names;
    private int count = 0;

    AttendanceSheet(int maxSize) {
        names = new String[maxSize];
    }

    void markPresent(String name) {
        if (isPresent(name)) {
            return; // already marked, no duplicates
        }
        if (count >= names.length) {
            System.out.println("Sheet is full, cannot mark " + name);
            return;
        }
        names[count] = name;
        count++;
    }

    int getPresentCount() {
        return count;
    }

    boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (names[i].equals(name)) {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println(sheet.getPresentCount()); // 2
        System.out.println(sheet.isPresent("Ben"));  // true
        System.out.println(sheet.isPresent("Chen")); // false
    }
}