package com.wizardrescue.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterTest {
    //fixtures
    Character character1;
    Character character2;
    Character character3;
    @Before
    public void setUp() {
        character1 = new Character("anvy", 100, "axe");
        character2 = new Character("sheila", 90, "morningstar");
        character3 = new Character("mark", 80, "sword");

    }

    @Test
    public void getName() {
        assertEquals("anvy", character1.getName());
        assertEquals("sheila", character2.getName());
        assertEquals("mark", character3.getName());
    }

    @Test
    public void getHealth() {
        assertEquals(100, character1.getHealth());
        assertEquals(90, character2.getHealth());
        assertEquals(80, character3.getHealth());
    }


    @Test
    public void getWeapon() {
        assertEquals("AXE", character1.getWeapon().name());
        assertEquals("MORNINGSTAR", character2.getWeapon().name());
        assertEquals("SWORD", character3.getWeapon().name());
    }



}