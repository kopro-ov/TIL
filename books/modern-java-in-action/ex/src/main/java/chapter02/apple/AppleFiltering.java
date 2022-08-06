package chapter02.apple;

import java.util.ArrayList;
import java.util.List;

import static chapter02.apple.Color.GREEN;

public class AppleFiltering {

    /**
     * 녹색 사과 구하기
     *
     * @param apples
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> apples) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }

    /**
     * 특정 색상 사과 구하기
     * @param apples
     * @param color
     * @return
     */
    public static List<Apple> filterApplesByColor(List<Apple> apples, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 특정 무게보다 큰 사과 구하기
     * @param apples
     * @param weight
     * @return
     */
    public static List<Apple> filterApplesByWeight(List<Apple> apples, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: apples) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 특정 색상과 무게 조건이 일치하는 사과 구하기
     * 이렇게 하면 앞으로 요구사항이 바뀌었을 떄 유연하게 대응할 수 없음.
     * 해결할 수 있는 방법은 동작 파라미터화
     * @param apples
     * @param color
     * @param weight
     * @param flag
     * @return
     */
    public static List<Apple> filterApples(List<Apple> apples, Color color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: apples) {
            if ((flag && apple.getColor().equals(color)) ||
                    (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }


}
