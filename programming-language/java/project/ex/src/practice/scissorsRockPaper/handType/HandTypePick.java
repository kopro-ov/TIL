package practice.scissorsRockPaper.handType;

import java.util.Scanner;

public class HandTypePick implements HandTypeBehavior{

    @Override
    public int choiceHandType() {

        Scanner stdIn = new Scanner(System.in);

        System.out.println("가위[1], 바위[2], 보[3]를 선택해주세요.");
        System.out.print("선택 : ");

        int handType = stdIn.nextInt();

        while (handType < 0 || handType > 3) {
            System.out.println("다시 선택해주세요");
            System.out.print("선택 : ");
            handType = stdIn.nextInt();
        }

        return handType;
    }
}
