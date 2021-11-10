package com.wizardrescue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hero extends Character {

    private List<String> items = new ArrayList<>();

    public Hero(String name, String weapon) {
        super(name, weapon);
    }

    public Hero(String name, int health, String weapon) {
        super(name, health, weapon);
    }

    public void fight(Character enemy) {

        while (enemy.getHealth() > 0 && getHealth() > 0) {
            Double rand = new Random().nextDouble();
            if (rand >= 0.0 && rand <= 0.35) {
                setHealth(getHealth() - 10);
                System.out.println( enemy.getName() + " has attacked you for " + enemy.getWeapon().damage() + " using " + enemy.getWeapon() + " and your health now is " + getHealth());

            } else {
                enemy.setHealth(enemy.getHealth() - getWeapon().damage());
                System.out.println("Your " + getWeapon() + " hits him. " + enemy.getName() + " has been attacked for "
                        + getWeapon().damage() + " and his health now is " + enemy.getHealth());
            }
            pause(1500);
        }

        if (getHealth() <= 0) {
            System.out.println("Hero " + getName() + " your health has dropped below 1, your journey has ended for now. Please try again!");
        } else {
            System.out.println("Congratulation you have defeated the " + enemy.getName());
        }
    }

    private static void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {

        }
    }
}