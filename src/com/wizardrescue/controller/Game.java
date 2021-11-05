package com.wizardrescue.controller;

import com.wizardrescue.Scene;

public class Game {

    private Scene scene = new Scene();
    boolean gameOver;


    public void execute() {
        welcome();
        scene.startAct(Scene.currentAct);
        //GAMEOVER
        ///////////
        //do more stuff
    }

    public void welcome() {
        System.out.println("WELCOME TO WIZARD RESCUE!");
    }

}