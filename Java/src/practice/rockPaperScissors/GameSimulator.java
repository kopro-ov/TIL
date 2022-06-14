package practice.rockPaperScissors;

import practice.rockPaperScissors.hand.Hand;
import practice.rockPaperScissors.hand.PlayerHand;
import practice.rockPaperScissors.hand.RobotHand;
import practice.rockPaperScissors.judge.Judge;

import java.util.Scanner;

public class GameSimulator {

    public static void main(String[] args) {


        Hand robot = new RobotHand();
        Hand player = new PlayerHand();
        Judge judge = new Judge();

        judge.gameStartGuide(player);

        boolean participationGame = true;
        while (participationGame) {

            robot.choiceHandType();
            player.choiceHandType();
            judge.resultGame(robot, player);

            participationGame = judge.callReplayGame();

        }

        judge.gameEndGuide();


    }

}
