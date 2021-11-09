package src.com.consoletesting;

public class Choice {
    public String getNumChoice() {
        return numChoice;
    }

    public void setNumChoice(String numChoice) {
        this.numChoice = numChoice;
    }

    private String numChoice;
    public Choice(String num) {
        this.numChoice = num;
    }
}