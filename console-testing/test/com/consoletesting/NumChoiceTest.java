package test.com.consoletesting;

import com.apps.util.Prompter;
import org.junit.Test;
import src.com.consoletesting.Choice;
import src.com.consoletesting.Name;
import src.com.consoletesting.NextLocation;
import src.com.consoletesting.Weapon;


import java.io.File;
import java.util.Scanner;
import static org.junit.Assert.*;

public class NumChoiceTest {

    @Test
    public void prompterShouldReadValuesFromFileInsteadOfHuman() throws Exception {
        // this Prompter HAS-A Scanner, and that Scanner reads input from a file ("responses.txt")
        Prompter prompter = new Prompter(new Scanner(new File("console-testing/responses/responses.txt")));

        String choice = prompter.prompt("Please enter your choice: ", "1|2", "Invalid choice: enter 1 or 2");
        String name  = prompter.prompt("Please enter your name: ", "[a-zA-Z]+", "That is not a valid name!");
        String weapon = prompter.prompt("Please enter your weapon: 1--Sword, 2--Morningstar, 3--Axe ", "1|2|3", "Invalid choice");
        String nextLocation = prompter.prompt("Please enter to proceed: ", "1", "Invalid choice: enter 1");

        Choice choice1 = new Choice(choice);
        Name name1 = new Name(name);
        Weapon weapon1 = new Weapon(weapon);
        NextLocation nextLocation1 = new NextLocation(nextLocation);

        assertEquals("1", choice1.getNumChoice());
        assertEquals("anvy", name1.getName());
        assertEquals("3",weapon1.getWeapon());
        assertEquals("1", nextLocation1.getNextLocation());
    }
}