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

    public void pickUp(String item) {
        // save item to items
    }

    public void fight(Character enemy) {
        Object obj = new Object();
        try {
            synchronized (obj) {
                while (enemy.getHealth() > 0 && getHealth() > 0) {
                    Double rand = new Random().nextDouble();
                    if (rand >= 0.0 && rand <= 0.3) {
                        setHealth(getHealth() - 10);
                        System.out.println(getName() + " has been attacked and your health now is " + getHealth());
                    } else {
                        enemy.setHealth(enemy.getHealth() - getWeapon().damage());
                        System.out.println(enemy.getName() + " has been attacked for "+getWeapon().damage() +" and his health now is "
                                + enemy.getHealth());
                    }
                    obj.wait(1500);
                }
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        if(getHealth() <=0){
            System.out.println("Health is now " + getHealth() + " game over");
        }
        else {
            System.out.println("Congratulation you have defeated the " + enemy.getName());
        }
    }
}