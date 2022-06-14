package practice.rockPaperScissors.judge;

import practice.rockPaperScissors.hand.Hand;

import java.util.Scanner;

public class Judge {



    public void resultGame(Hand player1, Hand player2) {

        System.out.printf("[%s]이 낸 값 : %s\n",player1.getPlayerName(), player1.getDisplayHand());
        System.out.printf("[%s]이 낸 값 : %s\n",player2.getPlayerName(), player2.getDisplayHand());

        //System.out.println(RockPaperScissors.가위);
        if(player1.getHandType() == player2.getHandType()) {
            System.out.println("결과는 무승부입니다.");
            return;
        }
        //플레이어1이 가위
        if(player1.getHandType() == 1) {
            if (player2.getHandType() == 2)
                System.out.println(player1.getPlayerName() + "이 이겼습니다.");
            else
                System.out.println(player1.getPlayerName() + "이 졌습니다.");
            return;
        }
        //플레이어1이 바위
        if(player1.getHandType() == 2) {
            if (player2.getHandType() == 1)
                System.out.println(player1.getPlayerName() + "이 이겼습니다.");
            else
                System.out.println(player1.getPlayerName() + "이 졌습니다.");
            return;
        }
        //플레이어1이 보
        if (player2.getHandType() == 3) {
            if (player2.getHandType() == 2)
                System.out.println(player1.getPlayerName() + "이 이겼습니다.");
            else
                System.out.println(player1.getPlayerName() + "이 졌습니다.");
        }

    }

    public boolean callReplayGame() {

        Scanner stdIn = new Scanner(System.in);
        System.out.println("========== 더 하실려면 1를 선택하시고 아닐 경우 0을 선택해주세요 ==========");

        int gameType = stdIn.nextInt();
        while(gameType != 1 && gameType != 0) {
            System.out.println("다시 선택해주세요");
            System.out.print("선택 : ");
            gameType = stdIn.nextInt();
        }

        if(gameType == 1)
            return true;
        else
            return false;
    }

    public void gameStartGuide(Hand player) {
        System.out.println("========== 플레이어의 이름을 입력해주세요. ==========");
        Scanner sc = new Scanner(System.in);
        player.setPlayerName(sc.next());

        System.out.printf("[심판] : 안녕하세요 %s님\n가위바위보게임에 오신걸 환영합니다.\n", player.getPlayerName());
        System.out.println("========== 가위바위보 게임을 시작하겠습니다 ==========");
    }

    public void gameEndGuide() {
        System.out.println("========== 가위바위보 게임이 종료되었습니다 ==========");
    }
}
