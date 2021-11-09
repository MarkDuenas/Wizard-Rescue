package src.com.consoletesting;

import com.apps.util.Prompter;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class NumChoiceClient {

    public static void main(String[] args) {
        // this Prompter HAS-A Scanner, and that Scanner reads input from the console (System.in)
        Prompter prompter = new Prompter(new Scanner(System.in));

        // all values solicited from the user via this Prompter are returned as String
        // this is a deliberate choice, as it allows you (or the prompter itself) to call
        // String.matches(regex) to ensure the input is valid for the case at hand
        String choice = prompter.prompt("Please enter your choice: ", "1|2", "Invalid choice: enter 1 or 2");
        String name  = prompter.prompt("Please enter your name: ", "[a-zA-Z]", "That is not a valid name!");
        String weapon = prompter.prompt("Please enter your weapon: 1--Sword, 2--Morningstar, 3--Axe ", "1|2|3", "Invalid choice");
         String nextLocation = prompter.prompt("Please enter to proceed: ", "1", "Invalid choice: enter 1");

        Choice choice1 = new Choice(choice);
        Name name1 = new Name(name);
        Weapon weapon1 = new Weapon(weapon);
        NextLocation nextLocation1 = new NextLocation(nextLocation);

        System.out.println(choice1);
        System.out.println(name1);
        System.out.println(weapon1);
        System.out.println(nextLocation);
    }
}