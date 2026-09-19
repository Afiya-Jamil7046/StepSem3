class Locker {
    private String code;
    private final int lockerNumber;

    Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    boolean changeCode(String oldCode, String newCode) {
        if (!code.equals(oldCode)) {
            System.out.println("Change rejected: wrong current code");
            return false;
        }
        code = newCode;
        System.out.println("Code changed successfully");
        return true;
    }

    int getLockerNumber() {
        return lockerNumber;
    }
}

public class Main {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        l.changeCode("1234", "5678"); // success
        l.changeCode("0000", "9999"); // rejected

        // proves the code is still 5678, since this only works with the old code "5678"
        l.changeCode("5678", "0000"); // success
    }
}