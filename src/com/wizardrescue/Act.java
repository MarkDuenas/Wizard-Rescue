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
    private Enemy enemy;
    private Hero hero;

    public Act(int actNumber, Hero hero) {
        setHero(hero);
        setActNumber(actNumber);
        // setLocation(location);
//        setStory(generateStory());
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
            result = Files.readAllLines(Path.of("data/act-" + getActNumber()
                    + "-location-" + location));
            printFile(result);
            triggerFight();
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
            triggerFight();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void triggerFight() {
        switch (getActNumber() + location + choice) {
            case "122":
                enemy = new Enemy("Mysterious Man", 80, "Axe");
                hero.fight(enemy);
                System.out.println("Enter 1 to go to the forest.");
//
            case "32":
                enemy = new Enemy("Farmer Quentin", 100, "Pitchfork");
                hero.fight(enemy);
        }

//        enemy = new Enemy("BarGuy", 100, "Axe");
//        story.forEach(line -> {
//            if (line.contains("FIGHT")) {
//                hero.fight(enemy);
//            }
//        });
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
}
