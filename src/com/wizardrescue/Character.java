package com.wizardrescue;

abstract class Character {

    private String name;
    private int health;
    private String description;
    private String weapon;

    //ctors
    public Character(String name, int health, String description, String weapon) {
        setName(name);
        setHealth(health);
        setDescription(description);
        setWeapon(weapon);
    }

    //Methods
    abstract public void fight (Character enemy);


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                ", description='" + getDescription() + '\'' +
                ", weapon='" + getWeapon() + '\'' +
                '}';
    }
}