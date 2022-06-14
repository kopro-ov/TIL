package practice.rockPaperScissors.hand;

import practice.rockPaperScissors.handType.HandTypeBehavior;

public abstract class Hand {

    HandTypeBehavior handTypeBehavior;

    String playerName;
    int handType;

    abstract void display();

    public int getHandType() {
        return handType;
    }

    public String getDisplayHand() {

        switch (handType) {
            case 1 : return "가위";
            case 2 : return "바위";
            case 3 : return "보";
            default: return "";
        }
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    void setHandTypeBehavior(HandTypeBehavior handTypeBehavior) {
        this.handTypeBehavior = handTypeBehavior;
    }

    public void choiceHandType() {
        handType = handTypeBehavior.choiceHandType();
    }

}
