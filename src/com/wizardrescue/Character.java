package com.wizardrescue;

abstract class Character {

    private String name;
    private int health = 100;
    private String weapon;

    //ctors
    public Character(String name, String weapon) {
        setName(name);
        setWeapon(weapon);
    }
    public Character(String name, int health, String weapon) {
        setName(name);
        setHealth(health);
        setWeapon(weapon);
    }

    //Methods
    abstract public void fight (Character enemy) throws InterruptedException;


    // Accessors
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "name='" + getName() + '\'' +
                ", health=" + getHealth() +
                ", weapon='" + getWeapon() + '\'' +
                '}';
    }
}