package controller;

import com.apps.util.Prompter;
import com.wizardrescue.Hero;
import com.wizardrescue.controller.Game;
import org.junit.Test;


import java.io.File;
import java.util.Scanner;
import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void prompterShouldReadValuesFromFileInsteadOfHuman() throws Exception {
        // this Prompter HAS-A Scanner, and that Scanner reads input from a file ("responses.txt")
        Prompter prompter = new Prompter(new Scanner(new File("test/responses/responses.txt")));

        String choice = prompter.prompt("Please enter your choice: ", "1|2", "Invalid choice: enter 1 or 2");
        String name  = prompter.prompt("Please enter your name: ", "[a-zA-Z]+", "That is not a valid name!");
        String weapon = prompter.prompt("Please enter your weapon: 1--Sword, 2--Morningstar, 3--Axe ", "1|2|3", "Invalid choice");

        String playAgain = prompter.prompt("Please enter your choice: ", "1|2", "Invalid Choice");

        if (weapon.equals("1")) {
           weapon = "sword";
        } else if (weapon.equals("2")) {
           weapon = "morningstar";
        } else if (weapon.equals("3")) {
            weapon = "axe";
        }

        Hero hero1 = new Hero(name, weapon);

        assertEquals("1", choice);
        assertEquals("jane", name);
        assertEquals("sword", weapon);

        assertEquals("1", playAgain);

    }

}