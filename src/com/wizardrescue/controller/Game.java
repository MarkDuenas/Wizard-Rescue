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
    boolean gameOver;
    public String playerName;
    private String weapon;
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
        playerName = prompter.prompt("Please enter your choice name: ");
        System.out.println(playerName);

        weapon = prompter.prompt("Please enter your weapon: 1--Sword, 2--Morningstar, 3--Axe  ", "1|2|3", "Invalid choice");
        System.out.println(weapon);
        insertWeapon(weapon);
        hero = new Hero(playerName, weapon);
        System.out.println(hero);

    }

    private void insertWeapon(String weapon) {
        if (weapon.equals("1")) {
            this.weapon = "sword";
        } else if (weapon.equals("2")) {
            this.weapon = "morningstar";
        } else if (weapon.equals("3")) {
            this.weapon = "axe";
        }
    }

    private void gameOver() {
        System.out.println("Game Over");
        System.out.println("Play again: Enter 1; Exit: Enter 2");
        String playAgain = prompter.prompt("Please enter your choice: ", "1|2", "Invalid Choice");
        System.out.println(playAgain);

        if (Integer.parseInt(playAgain) == 2) {
            //exit game
        } else if (Integer.parseInt(playAgain) == 1) {
            execute();
        }
    }
}