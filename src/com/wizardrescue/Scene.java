package com.wizardrescue;

import com.apps.util.Prompter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Scene {
    public static int currentAct = 1;
    private Hero hero;
    private Enemy enemy;
    private Prompter prompter = new Prompter(new Scanner(System.in));

    public void startAct() {

        if (Scene.currentAct > 3) {
            return;
        }
        Act act = new Act(Scene.currentAct);
        System.out.println("ACT" + Scene.currentAct + "START");

        act.generateStory();


        String choice = prompter.prompt("Please choose: ");
        System.out.println(choice);


        act.generateLocation(choice);
        if (Scene.currentAct != 3) {
            String location = prompter.prompt("Please choose: ");
            System.out.println(location);

            act.generateOptions(location);

            String option = prompter.prompt("Please choose: ");
            System.out.println(option);
        }


        Enemy enemy = new Enemy("Juan", 100, "Ax");
        Hero hero = new Hero("Joe", "Sword");
        hero.fight(enemy);

        setCurrentAct(++Scene.currentAct);
        startAct();
    }

    public static void setCurrentAct(int currentAct) {
        Scene.currentAct = currentAct;
    }
}