package com.wizardrescue;

import java.util.ArrayList;
import java.util.List;

public class Hero extends Character {

    private List<String> items = new ArrayList<>();


    public Hero(String name, int health, String description, String weapon) {
        super(name, health, description, weapon);
    }

    public void choose(int choice) {
        // choose an option
    }

    public void pickUp(String item) {
        // save item to items
    }

    @Override
    public void fight(Character enemy) {
        //subtract from enemy health.
    }
}