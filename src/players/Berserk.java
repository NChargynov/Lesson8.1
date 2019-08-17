package players;

import boss.Boss;

import java.util.Random;

public class Berserk extends Hero {
    public Berserk(int health, int damage) {
        super(health, damage, Ability.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void useSuperPower(Hero[] heroes, Boss boss) {
        Random r = new Random();
        int a = r.nextInt(2) + 2;
        int a2 = heroes[2].getDamage() * a;
        boss.setHealth(boss.getHealth() - a);
        System.out.println("Berserk critical damage - " + a2);
    }
}
