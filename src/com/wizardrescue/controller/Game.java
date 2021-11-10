package com.wizardrescue.controller;

import com.apps.util.Prompter;
import com.wizardrescue.Hero;
import com.wizardrescue.Scene;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private Scene scene = new Scene();
    public String playerName;
    Hero hero;
    Prompter prompter = new Prompter(new Scanner(System.in));

    public void execute() {
        welcome();
        scene.startAct(hero);
        gameOver();
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
        System.out.println(result);

        if (Integer.parseInt(result) == 2) {
            gameOver();
        }
        playerName = prompter.prompt("Please enter your name: ");
        System.out.println(playerName);

        String weapon = prompter.prompt("Please enter your weapon: 1--Sword, 2--Morningstar, 3--Axe ", "1|2|3", "Invalid choice");
        String heroWeapon = insertWeapon(weapon);
        hero = new Hero(playerName, heroWeapon);
        System.out.println(hero);

    }

    private String insertWeapon(String weapon) {
        String result = null;
        if (weapon.equals("1")) {
            result = "sword";
        } else if (weapon.equals("2")) {
            result = "morningstar";
        } else if (weapon.equals("3")) {
            result = "axe";
        }
        return result;
    }

    private void gameOver() {
        System.out.println("Game Over");
        System.out.println("Play again: Enter 1; Exit: Enter 2");
        String playAgain = prompter.prompt("Please enter your choice: ", "1|2", "Invalid Choice");
        System.out.println(playAgain);

        if (Integer.parseInt(playAgain) == 2) {
            //exit game
            System.exit(0);
        } else if (Integer.parseInt(playAgain) == 1) {
            execute();
        }
    }
}