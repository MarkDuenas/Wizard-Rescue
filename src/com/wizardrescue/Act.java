package com.wizardrescue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

class Act {

    private int actNumber;
    private String location;
    private String choice;
    private Hero hero;

    public Act(int actNumber, Hero hero) {
        setHero(hero);
        setActNumber(actNumber);
    }


    public List<String> generateStory() {
        List<String> result = new ArrayList<>();
        try {
            result = Files.readAllLines(Path.of("data/act-" + getActNumber()));
            printFile(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<String> generateLocation(String location) {
        setLocation(location);
        List<String> result = new ArrayList<>();
        try {
            result = Files.readAllLines(Path.of("data/act-" + getActNumber()
                    + "-location-" + location));
            if(checkFight()) {
                triggerFight();
                if(getHero().getHealth() <= 0) {
                    return result;
                }
            }
            printFile(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<String> generateOptions(String choice) {
        setChoice(choice);
        List<String> result = new ArrayList<>();
        try {
            result = Files.readAllLines(Path.of("data/act-" + getActNumber() + "-location-"
                    + location + "-opt-" + choice));
            printFile(result);
            if (checkFight()) {
                triggerFight();
                if(getHero().getHealth() <= 0) {
                    return result;
                }
                System.out.println("Enter 1 to go to the " + Location.FOREST);
            }
            updateHealth();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void updateHealth(){
        if(getActNumber() == 2 && "2".equals(getLocation()) && "1".equals(getChoice())){
            hero.setHealth(100);
            System.out.println("Hero's health is now: " + hero.getHealth());
            System.out.println("Enter 1 to continue to the farm.");
        }
        else if(getActNumber() == 1 && "1".equals(location) && "2".equals(choice)){
            hero.setHealth(hero.getHealth() - 20);
            System.out.println("Hero's health is now: " + hero.getHealth());
            System.out.println("Enter 1 to continue to the forest.");
        }
        else if(getActNumber() == 2 && "1".equals(location) && "2".equals(choice)){
            hero.setHealth(hero.getHealth() - 20);
            System.out.println("Hero's health is now: " + hero.getHealth());
            System.out.println("Enter 1 to continue to the farm.");
        }

    }

    public boolean checkFight() {
        boolean fight = false;
        if (getActNumber() == 3 && "2".equals(location)) {
            fight = true;
        } else if (getActNumber() == 1 && "2".equals(location) && "2".equals(choice)) {
            fight = true;
        }
        return fight;
    }

    public void triggerFight() {
        Character enemy;
        if(getActNumber() == 1) {
            enemy = new Character("Mysterious Gentleman", 80, "brassknuckle");
        } else {
            enemy = new Character("Farmer Quentin", 100, "pitchfork");
        }
        getHero().fight(enemy);
    }

    public List<String> endScene() {
        List<String> result = new ArrayList<>();
        try {
            result = Files.readAllLines(Path.of("data/conclusion"));
            printFile(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void printFile(List<String> prompt) {
        prompt.forEach(System.out::println);
    }

    public void setActNumber(int actNumber) {
        this.actNumber = actNumber;
    }

    public int getActNumber() {
        return actNumber;
    }


    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public String getChoice() {
        return choice;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

}
