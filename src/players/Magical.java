package players;

import boss.Boss;

import java.util.Random;

public class Magical extends Hero {
    public Magical(int health, int damage) {
        super(health, damage, Ability.BOOST);
    }

    @Override
    public void useSuperPower(Hero[] heroes, Boss boss) {
        Random r = new Random();
        int a = r.nextInt(10);
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].setDamage(heroes[i].getDamage() + a);
            System.out.println("Magical increased attack of every hero on " + a);
        }
    }
}
