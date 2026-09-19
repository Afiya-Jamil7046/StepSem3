class Character {
    private int health;
    private final int maxHealth;

    Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    void takeDamage(int amount) {
        if (amount < 0) {
            System.out.println("Damage rejected: amount cannot be negative");
            return;
        }
        health = Math.max(0, health - amount);
    }

    void heal(int amount) {
        if (amount < 0) {
            System.out.println("Heal rejected: amount cannot be negative");
            return;
        }
        health = Math.min(maxHealth, health + amount);
    }

    int getHealth() {
        return health;
    }
}

public class Main {
    public static void main(String[] args) {
        Character c = new Character(100);

        c.takeDamage(30);
        System.out.println("health = " + c.getHealth()); // 70

        c.heal(50);
        System.out.println("health = " + c.getHealth()); // 100 (capped)

        c.takeDamage(150);
        System.out.println("health = " + c.getHealth()); // 0 (floored)
    }
}