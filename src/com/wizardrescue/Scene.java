package com.wizardrescue;

import com.apps.util.Console;
import com.apps.util.Prompter;

import java.util.List;
import java.util.Scanner;

public class Scene {
    public static int currentAct = 1;
    private Hero hero;
    private Prompter prompter;

    public Scene(Prompter prompter, Hero hero) {
        this.prompter = prompter;
        setHero(hero);
    }

    public void startAct() {
        Act act = new Act(Scene.currentAct, getHero());

        act.generateStory();
        Console.blankLines(3);
        String choice = prompter.prompt("Please enter your choice: ", "1|2", "Invalid choice: enter 1 or 2");

        Console.blankLines(3);
        act.generateLocation(choice);
        Console.blankLines(3);

        if (Scene.currentAct != 3) {
            String location = prompter.prompt("Please enter your choice: ", "1|2", "Invalid choice: enter 1 or 2");
            Console.blankLines(3);
            act.generateOptions(location);
            Console.blankLines(3);
            if (this.hero.getHealth() > 0) {
                 prompter.prompt("Please enter to proceed: ", "1", "Invalid choice: enter 1");
            }
        }

        if (Scene.currentAct == 3) {
            act.endScene();
        }

        setCurrentAct(++Scene.currentAct);
    }

//    public List<String> introToAct() {
//        Act act = new Act(Scene.currentAct, this.hero);
//        act.generateStory();
//        Console.blankLines(3);
//    }

    public static void setCurrentAct(int currentAct) {
        Scene.currentAct = currentAct;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}