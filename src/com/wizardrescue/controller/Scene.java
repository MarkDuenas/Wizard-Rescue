package com.wizardrescue.controller;

import com.apps.util.Console;
import com.apps.util.Prompter;
import com.wizardrescue.Hero;

public class Scene {
    public static int currentAct = 1;
    private Hero hero;
    private Prompter prompter;

    public Scene(Prompter prompter, Hero hero) {
        setHero(hero);
        this.prompter = prompter;
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
            if (getHero().getHealth() > 0) {
                 prompter.prompt("Please enter to proceed: ", "1", "Invalid choice: enter 1");
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