class PasswordChecker {
    private final String password;

    PasswordChecker(String password) {
        this.password = password;
    }

    String getStrength() {
        int len = password.length();
        if (len < 6) {
            return "Weak";
        } else if (len < 10) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PasswordChecker pc = new PasswordChecker("abcd");
        System.out.println(pc.getStrength());   // Weak

        PasswordChecker pc1 = new PasswordChecker("abcdefgh");
        System.out.println(pc1.getStrength());  // Medium

        PasswordChecker pc2 = new PasswordChecker("abcdefghij");
        System.out.println(pc2.getStrength());  // Strong
    }
}