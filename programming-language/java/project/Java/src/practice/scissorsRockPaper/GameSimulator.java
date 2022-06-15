package practice.scissorsRockPaper;

import practice.scissorsRockPaper.hand.Hand;
import practice.scissorsRockPaper.hand.PlayerHand;
import practice.scissorsRockPaper.hand.RobotHand;
import practice.scissorsRockPaper.judge.Judge;

import java.util.Scanner;

public class GameSimulator {

    public static void main(String[] args) {

        System.out.println("========== 플레이어의 이름을 입력해주세요. ==========");
        Scanner sc = new Scanner(System.in);

        Hand robot = new RobotHand();
        Hand player = new PlayerHand(sc.next());

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
