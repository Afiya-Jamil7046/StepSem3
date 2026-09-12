public class Q2 {
    static String findDuplicateTeam(String[] teamNames) {
        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        String[] t1 = {"ByteForce", "CodeCrafters", "ByteForce"};
        String[] t2 = {"ByteForce", "CodeCrafters", "NullPointers"};
        System.out.println(findDuplicateTeam(t1)); // Duplicate Found: ByteForce
        System.out.println(findDuplicateTeam(t2)); // No Duplicates Found
    }
}