package com.wizardrescue;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.Map;

import static org.junit.Assert.*;

public class HeroTest {

    Hero hero;
    Character enemy;

    @Test
    public void fight_heroWinsFight_whenEnemyHealthReaches0() {
        hero = new Hero("Larry", 100, "sword");
        enemy = new Character("Evil Witch", 10, "axe");
        hero.fight(enemy);
        assertTrue("Congratulation you have defeated the Evil Witch", true);
    }

    @Test
    public void fight_gameOVer_whenHeroHealthReaches0() {
        hero = new Hero("Joe", 10, "sword");
        enemy = new Character("Witch", 100, "pitchfork");
        hero.fight(enemy);
        assertTrue("Health is now 0 game over", true);
    }

}