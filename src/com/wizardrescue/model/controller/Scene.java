package com.wizardrescue.model.controller;

import com.apps.util.Console;
import com.apps.util.Prompter;
import com.wizardrescue.model.Hero;

public class Scene {
    public static int currentAct = 1;
    private Hero hero;
    private Prompter prompter;

    public Scene(Prompter prompter, Hero hero) {
        setHero(hero);
        this.prompter = prompter;
    }

    public void startAct() {
        Console.clear();
        System.out.println(hero);
        Act act = new Act(Scene.currentAct, getHero());

        act.generateStory();
        Console.blankLines(3);
        String choice = prompter.prompt("Please enter your choice: ", "1|2", "Invalid choice: enter 1 or 2");

        if (Scene.currentAct != 3) {
            Console.clear();
        }

        act.generateLocation(choice);
        Console.blankLines(3);

        if (Scene.currentAct != 3) {
            String location = prompter.prompt("Please enter your choice: ", "1|2", "Invalid choice: enter 1 or 2");
            Console.clear();

            act.generateOptions(location);
            Console.blankLines(3);
            if (getHero().getHealth() > 0) {
                prompter.prompt("Please enter to proceed: ", "1", "Invalid choice: enter 1");
                Console.clear();
            }
        }

        if (Scene.currentAct == 3) {
            act.endScene();
        }

        setCurrentAct(++Scene.currentAct);
    }


    public static void setCurrentAct(int currentAct) {
        Scene.currentAct = currentAct;
    }

    private Hero getHero() {
        return hero;
    }

    private void setHero(Hero hero) {
        this.hero = hero;
    }
}