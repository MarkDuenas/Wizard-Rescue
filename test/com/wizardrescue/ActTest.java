package com.wizardrescue;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.apps.util.Prompter;
import org.junit.Before;
import org.junit.Test;

public class ActTest {
    Hero hero;
    Act act;

    @Before
    public void setUp() {
        hero = new Hero("Dude", 100, "axe");
        act = new Act(1, hero);
    }

    @Test
    public void generateStory_shouldReturnListOfStringFromTextFileForAct1() throws IOException {
        List<String> result = act.generateStory();
        List<String> expected = Files.readAllLines(Path.of("data/act-1"));

        assertEquals(expected, result);
    }

    @Test
    public void generateLocation_shouldReturnListOfStringFromTextFileWithLocationNameForAct1() throws IOException{
        List<String> result = act.generateLocation("1");
        List<String> expected = Files.readAllLines(Path.of("data/act-1-location-1"));
        assertEquals(expected, result);

        result = act.generateLocation("2");
        expected = Files.readAllLines(Path.of("data/act-1-location-2"));

        assertEquals(expected, result);
    }

}