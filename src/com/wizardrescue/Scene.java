package com.wizardrescue;

import com.apps.util.Prompter;

import java.util.Scanner;

public class Scene {
    public static int currentAct = 1;
    private Hero hero;
    private Enemy enemy;
    private Prompter prompter = new Prompter(new Scanner(System.in));

    public void startAct(int currentAct) {
        if(Scene.currentAct > 3){
            return;
        }
        Act act = new Act(currentAct, Location.LIBRARY);
        System.out.println("ACT" + Scene.currentAct + "START");
        String result = prompter.prompt("Please type something: ");
        System.out.println(result);

        setCurrentAct(++Scene.currentAct);
        startAct(Scene.currentAct);
    }

    public static void setCurrentAct(int currentAct) {
        Scene.currentAct = currentAct;
    }
}