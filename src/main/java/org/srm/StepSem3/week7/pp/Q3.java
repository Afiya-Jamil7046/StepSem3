final class NameTag {
    private final String firstName;
    private final char lastInitial;

    NameTag(String fullName) {
        String[] parts = fullName.split(" ");
        this.firstName = parts[0];
        this.lastInitial = parts[1].charAt(0);
    }

    String getNickname() {
        return firstName + " " + lastInitial + ".";
    }
}

public class Main {
    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname());

        NameTag tag2 = new NameTag("Maria Gomez");
        System.out.println(tag2.getNickname());
        System.out.println(tag == tag2); // false, same behavior but separate objects
    }
}