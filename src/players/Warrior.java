package players;

import boss.Boss;

public class Warrior extends Hero {
    public Warrior(int health, int damage) {
        super(health, damage, Ability.CRITICAL_DAMAGE);
    }

    @Override
    public void useSuperPower(Hero[] heroes, Boss boss) {

        int w = (heroes[0].getDamage() + boss.getDamage());
        boss.setHealth(boss.getHealth() - w);
        System.out.println("Warrior Super Power - " + w);
    }
}
