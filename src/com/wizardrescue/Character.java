package com.wizardrescue;

class Character {

    private String name;
    private int health = 100;
    private Weapon weapon;

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

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = Weapon.valueOf(weapon.toUpperCase());
    }

    // inner class(enum)
    enum Weapon {
        SWORD("Sword", 12),
        AXE("Axe", 15),
        MORNINGSTAR("Morningstar", 10),
        PITCHFORK("Pitchfork", 12),
        BRASSKNUCKLE("Brass Knuckle", 10);

        private String display;
        private int damage;

        Weapon(String display, int damage) {
            this.display = display;
            this.damage = damage;
        }

        public String display() {
            return display;
        }

        public int damage() {
            return damage;
        }
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