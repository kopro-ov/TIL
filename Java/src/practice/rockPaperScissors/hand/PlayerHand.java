package practice.rockPaperScissors.hand;

import practice.rockPaperScissors.handType.HandTypePick;

import java.util.Scanner;

public class PlayerHand extends Hand{

    public PlayerHand() {
        handTypeBehavior = new HandTypePick();
    }

    @Override
    void display() {
        System.out.println("유저");
    }

}
