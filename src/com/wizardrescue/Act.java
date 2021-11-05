package com.wizardrescue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

class Act {

    private int actNumber;
    Location location;
    List<String> story;

    public Act(int actNumber, Location location) {
        setActNumber(actNumber);
        setLocation(location);
//        setStory(generateStory());
    }

    private List<String> generateStory() {
        List<String> result = new ArrayList<>();
        try {
            result = Files.readAllLines(Path.of("data/act-" + getActNumber()));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    public int getActNumber() {
        return actNumber;
    }

    public void setActNumber(int actNumber) {
        this.actNumber = actNumber;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<String> getStory() {
        return story;
    }

    public void setStory(List<String> story) {
        this.story = story;
    }
}