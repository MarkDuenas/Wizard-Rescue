package com.wizardrescue;

import com.apps.util.Console;
import com.apps.util.Prompter;

import java.util.Scanner;

public class Scene {
    public static int currentAct = 1;
    private Hero hero;
    private Prompter prompter = new Prompter(new Scanner(System.in));

    public void startAct(Hero hero) {
        this.hero = hero;

        if (Scene.currentAct > 3) {
            currentAct = 1;
            return;
        }

        Act act = new Act(Scene.currentAct, this.hero);

        act.generateStory();

        String choice = prompter.prompt("Please enter your choice: ", "1|2", "Invalid choice: enter 1 or 2");
        System.out.println(choice);

        act.generateLocation(choice);

        if (Scene.currentAct != 3) {
            String location = prompter.prompt("Please enter your choice: ", "1|2", "Invalid choice: enter 1 or 2");
            System.out.println(location);

            act.generateOptions(location);

            String option = prompter.prompt("Please enter your choice: ", "1", "Invalid choice: enter 1");
            System.out.println(option);
        }

        Console.blankLines(20);
        setCurrentAct(++Scene.currentAct);
        startAct(this.hero);
        act.endScene();
    }

    public static void setCurrentAct(int currentAct) {
        Scene.currentAct = currentAct;
    }
}