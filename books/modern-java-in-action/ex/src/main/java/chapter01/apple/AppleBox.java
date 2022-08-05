package chapter01.apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AppleBox {

    private List<Apple> apples = new ArrayList<>();

    private void addApple(Apple apple) {
        apples.add(apple);
    }

    public static AppleBox createAppleBox(List<Apple> apples, Predicate<Apple> p) {

        AppleBox appleBox = new AppleBox();

        for (Apple apple : apples) {
            if (p.test(apple)) {
                appleBox.addApple(apple);
            }
        }

        return appleBox;
    }

    public List<Apple> getApples() {
        return apples;
    }

}
