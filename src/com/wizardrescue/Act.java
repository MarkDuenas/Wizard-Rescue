package com.wizardrescue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

class Act {

    private int actNumber;
    String location;
    String choice;
    List<String> story;
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
        this.location = location;
        List<String> result = new ArrayList<>();
        try {
            if(checkFight()) {
                triggerFight();
            }
            result = Files.readAllLines(Path.of("data/act-" + getActNumber()
                    + "-location-" + location));
            printFile(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<String> generateOptions(String choice) {
        this.choice = choice;
        List<String> result = new ArrayList<>();
        try {
            result = Files.readAllLines(Path.of("data/act-" + getActNumber() + "-location-"
                    + location + "-opt-" + choice));
            printFile(result);
            if (checkFight()) {
                triggerFight();
                System.out.println("Enter 1 to go to the forest.");
            }
            updateHealth();

//            if(checkScene()) {
//                minusHealth();
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void updateHealth(){
        if(getActNumber() == 2 && "2".equals(location) && "1".equals(choice)){
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

    public void minusHealth() {
        hero.setHealth(hero.getHealth() - 20);
        System.out.println();
        System.out.println("Hero's health: " + hero.getHealth());
        System.out.println();
        if(getActNumber() == 1) {
            System.out.println("Enter 1 to continue to the forest.");
        } else if (getActNumber() == 2) {
            System.out.println("Enter 1 to continue to the farm.");
        }
    }

    public boolean checkScene() {
        boolean scene = false;
        if (getActNumber() == 1 && "1".equals(location) && "2".equals(choice)) {
            scene = true;
        } else if(getActNumber() == 2 && "1".equals(location) && "2".equals(choice)){
            scene = true;
        }
        return scene;
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
        hero.fight(enemy);
    }

    private void printFile(List<String> prompt) {
        prompt.forEach(System.out::println);
    }

    private void setActNumber(int actNumber) {
        this.actNumber = actNumber;
    }

    public int getActNumber() {
        return actNumber;
    }


    public List<String> getStory() {
        return story;
    }

    public void setStory(List<String> story) {
        this.story = story;
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
}
