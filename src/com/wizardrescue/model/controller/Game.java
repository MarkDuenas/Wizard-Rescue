package com.wizardrescue.model.controller;

import com.apps.util.Prompter;
import com.wizardrescue.model.Hero;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Game {

    private boolean gameOver;
    private Hero hero;
    private Prompter prompter = new Prompter(new Scanner(System.in));
    private Scene scene;

    public void execute() {
        welcome();
        startScene();
        gameOver();
    }

    private void startScene() {
        scene = new Scene(prompter, hero);
        while (!gameOver) {
            if (hero.getHealth() > 0 && Scene.currentAct <= 3) {
                scene.startAct();
            }
            else {
                Scene.setCurrentAct(1);
                gameOver = true;
            }
        }
    }

    public void welcome() {
        try {
            Files.readAllLines(Path.of("data/introduction")).forEach(
                    line -> System.out.println(line)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        String result = prompter.prompt("Please enter your choice: ", "1|2", "Invalid choice: enter 1 or 2");
        System.out.println();

        if (Integer.parseInt(result) == 2) {
            gameOver();
        }
        String playerName = prompter.prompt("Please enter your name: ");
        System.out.println();

        String weapon = prompter.prompt("Please enter your weapon: 1--Sword, 2--Morningstar, 3--Axe ", "1|2|3",
                "Invalid choice");
        String heroWeapon = insertWeapon(weapon);
        hero = new Hero(playerName, heroWeapon);
    }

    private String insertWeapon(String weapon) {
        String result = null;
        switch (weapon) {
            case "1":
                result = "sword";
                break;
            case "2":
                result = "morningstar";
                break;
            case "3":
                result = "axe";
                break;
        }
        return result;
    }

    private void gameOver() {
        System.out.println("\nGame Over");
        System.out.println("Play again: Enter 1; Exit: Enter 2");
        String playAgain = prompter.prompt("Please enter your choice: ", "1|2", "Invalid Choice");
        System.out.println(playAgain);

        if (Integer.parseInt(playAgain) == 2) {
            System.exit(0);
        } else if (Integer.parseInt(playAgain) == 1) {
            gameOver = false;
            execute();
        }
    }
}