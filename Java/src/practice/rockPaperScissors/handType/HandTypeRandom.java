package practice.rockPaperScissors.handType;

import java.util.Random;

public class HandTypeRandom implements HandTypeBehavior {
    @Override
    public int choiceHandType() {

        System.out.println("가위, 바위, 보 중 랜덤 선택합니다");
        Random random = new Random();
        return random.nextInt(3 - 1 + 1) + 1;

    }
}
