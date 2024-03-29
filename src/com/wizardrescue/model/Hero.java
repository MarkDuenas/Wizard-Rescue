package com.wizardrescue.model;

import java.util.Random;

public class Hero extends Character {

    public Hero(String name, String weapon) {
        super(name, weapon);
    }

    public Hero(String name, int health, String weapon) {
        super(name, health, weapon);
    }

    public void fight(Character enemy) {
        pause(3000);
        while (enemy.getHealth() > 0 && getHealth() > 0) {
            Double rand = new Random().nextDouble();
            if (rand >= 0.0 && rand <= 0.35) {
                setHealth(getHealth() - enemy.getWeapon().damage());
                System.out.println( enemy.getName() + " has attacked you for " + enemy.getWeapon().damage() + " using "
                        + enemy.getWeapon().display() + " and your health now is " + getHealth());

            } else {
                enemy.setHealth(enemy.getHealth() - getWeapon().damage());
                System.out.println("Your " + getWeapon().display() + " hits him. " + enemy.getName() + " has been attacked for "
                        + getWeapon().damage() + " and his health now is " + enemy.getHealth());
            }
            pause(1500);
        }

        if (getHealth() <= 0) {
            System.out.println("\nHero " + getName() + ", your health has dropped below 1, your journey has ended for now. Please try again!");
            System.out.println();
        } else {
            System.out.println("\nCongratulations! You have defeated " + enemy.getName());
            System.out.println();
            System.out.println("Your current health is now: " + getHealth());
            System.out.println();
        }
    }

    private static void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {

        }
    }
}