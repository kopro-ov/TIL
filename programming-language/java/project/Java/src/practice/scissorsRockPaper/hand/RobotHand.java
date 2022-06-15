package practice.scissorsRockPaper.hand;

import practice.scissorsRockPaper.handType.HandTypeRandom;

public class RobotHand extends Hand {

    public RobotHand() {
        handTypeBehavior = new HandTypeRandom();
        this.setPlayerName("로봇");
    }

    @Override
    void display() {
        System.out.println("로봇");
    }

}
