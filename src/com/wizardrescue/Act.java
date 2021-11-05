package com.wizardrescue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

class Act {

    private int actNumber;
    String location;
    List<String> story;

    public Act(int actNumber) {
        setActNumber(actNumber);
        // setLocation(location);
//        setStory(generateStory());
    }


    public List<String> generateStory() {
        List<String> result = new ArrayList<>();
        try {
            result = Files.readAllLines(Path.of("data/act-" + getActNumber()));
            result.forEach(line -> System.out.println(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<String> generateLocation(String choice) {
        location = choice;
        List<String> result = new ArrayList<>();
        try {
            result = Files.readAllLines(Path.of("data/act-" + getActNumber()
            + "-location-" + choice));
            result.forEach(line -> System.out.println(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<String> generateOptions(String choice) {
        List<String> result = new ArrayList<>();
            try {
                Files.readAllLines(Path.of("data/act-" + Scene.currentAct + "-location-"
                        + location + "-opt-" + choice)).forEach(
                        line -> System.out.println(line)
                );
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        return result;
    }


    private void setActNumber(int actNumber) {
        this.actNumber = actNumber;
    }

    public int getActNumber() {
        return actNumber;
    }


        public List<String> getStory () {
            return story;
        }

        public void setStory (List < String > story) {
            this.story = story;
        }
    }
