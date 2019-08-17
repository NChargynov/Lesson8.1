package game;

import boss.Boss;
import players.*;

public class RpgGame {

    public static void startGame() {
        Boss boss = new Boss(400, 30);
        Hero[] heroes = getHeroesArray();
        while (!isFinished(heroes, boss)) {
            round(heroes, boss);
        }
    }

    private static void round(Hero[] heroes, Boss boss) {
        bossHit(heroes, boss);
        heroesHit(heroes, boss);
        showStatistics(heroes, boss);
        heroesApplySuperPower(heroes, boss);
    }

    private static boolean isFinished(Hero[] heroes, Boss boss) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDied = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDied = false;
                break;
            }
        }
        if (allHeroesDied) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDied;
    }

    private static Hero[] getHeroesArray() {
        Warrior warrior = new Warrior(100, 10);
        Medical medical = new Medical(100, 0);
        Magical magical = new Magical(100, 10);
        Berserk berserk = new Berserk(100, 10);

        Hero[] heroes = {warrior, medical, berserk, magical};
        return heroes;

        // Hero[] heroes = {
        //        new Warrior(health: 100,damage: 10),
        //        new Medical(health: 100,damage: 10),
        //        new Magical(health: 100,damage: 10),
        //        new Berserk(health: 100,damage: 10)};
        // return heroes;
    }

    private static void bossHit(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
        }
    }

    private static void heroesHit(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

    private static void heroesApplySuperPower(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].useSuperPower(heroes, boss);
            }
        }
    }

    private static void showStatistics(Hero[] heroes, Boss boss) {
        System.out.println("____________________");
        System.out.println("Boss health - " + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println("Hero " + heroes[i].getClass().getSimpleName() +
                    " - " + heroes[i].getHealth());
        }
        System.out.println("____________________");
    }
}
