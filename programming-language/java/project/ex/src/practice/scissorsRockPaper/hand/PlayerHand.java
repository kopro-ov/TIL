package practice.scissorsRockPaper.hand;

import practice.scissorsRockPaper.handType.HandTypePick;

public class PlayerHand extends Hand{

    public PlayerHand(String playerName) {
        handTypeBehavior = new HandTypePick();
        this.playerName = playerName;
    }

    @Override
    void display() {
        System.out.println("유저");
    }

}
