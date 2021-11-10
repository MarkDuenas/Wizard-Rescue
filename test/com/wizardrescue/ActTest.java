package com.wizardrescue;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


import com.wizardrescue.controller.Act;
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
    public void generateStory_shouldReturnListOfStringFromTextFileForAct2() throws IOException {
        act.setActNumber(2);
        List<String> result = act.generateStory();
        List<String> expected = Files.readAllLines(Path.of("data/act-2"));
        assertEquals(expected, result);
    }

    @Test
    public void generateStory_shouldReturnListOfStringFromTextFileForAct3() throws IOException {
        act.setActNumber(3);
        List<String> result = act.generateStory();
        List<String> expected = Files.readAllLines(Path.of("data/act-3"));
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


    @Test
    public void generateLocation_shouldReturnListOfStringFromTextFileWithLocationNameForAct2() throws IOException {
        act.setActNumber(2);
        List<String> result = act.generateLocation("1");
        List<String> expected = Files.readAllLines(Path.of("data/act-2-location-1"));
        assertEquals(expected, result);

        result = act.generateLocation("2");
        expected = Files.readAllLines(Path.of("data/act-2-location-2"));

        assertEquals(expected, result);
    }

    @Test
    public void generateLocation_shouldReturnListOfStringFromTextFileWithLocationNameForAct3() throws IOException {
        act.setActNumber(3);
        List<String> result = act.generateLocation("1");
        List<String> expected = Files.readAllLines(Path.of("data/act-3-location-1"));
        assertEquals(expected, result);

        result = act.generateLocation("2");
        expected = Files.readAllLines(Path.of("data/act-3-location-2"));

        assertEquals(expected, result);
    }

    @Test
    public void generateOptions_shouldReturnListOfStringFromTextFileWithLocationOptionForAct1() throws IOException {
        act.setLocation("1");
        List<String> result = act.generateOptions("1");
        List<String> expected = Files.readAllLines(Path.of("data/act-1-location-1-opt-1"));
        assertEquals(expected, result);

        act.setLocation("1");
        result = act.generateOptions("2");
        expected = Files.readAllLines(Path.of("data/act-1-location-1-opt-2"));
        assertEquals(expected, result);

        act.setLocation("2");
        result = act.generateOptions("1");
        expected = Files.readAllLines(Path.of("data/act-1-location-2-opt-1"));
        assertEquals(expected, result);

        act.setLocation("2");
        result = act.generateOptions("2");
        expected = Files.readAllLines(Path.of("data/act-1-location-2-opt-2"));
        assertEquals(expected, result);
    }

    @Test
    public void generateOptions_shouldReturnListOfStringFromTextFileWithLocationOptionForAct2() throws IOException {
        act.setActNumber(2);

        act.setLocation("1");
        List<String> result = act.generateOptions("1");
        List<String> expected = Files.readAllLines(Path.of("data/act-2-location-1-opt-1"));
        assertEquals(expected, result);

        act.setLocation("1");
        result = act.generateOptions("2");
        expected = Files.readAllLines(Path.of("data/act-2-location-1-opt-2"));
        assertEquals(expected, result);

        act.setLocation("2");
        result = act.generateOptions("1");
        expected = Files.readAllLines(Path.of("data/act-2-location-2-opt-1"));
        assertEquals(expected, result);

        act.setLocation("2");
        result = act.generateOptions("2");
        expected = Files.readAllLines(Path.of("data/act-2-location-2-opt-2"));
        assertEquals(expected, result);
    }
}