package com.wizardrescue;

public class Enemy extends Character {

    private String type;

    public Enemy(String name, int health, String description, String weapon) {
        super(name, health, description, weapon);
    }

    @Override
    public void fight(Character enemy) {

    }
}