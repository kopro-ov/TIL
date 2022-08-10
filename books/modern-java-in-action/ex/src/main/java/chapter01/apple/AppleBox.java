package chapter01.apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class AppleBox {

    private List<Apple> apples = new ArrayList<>();

    private void addApple(Apple apple) {
        apples.add(apple);
    }

    public static AppleBox createAppleBox(List<Apple> apples, Predicate<Apple> p) {

        AppleBox appleBox = new AppleBox();
        appleBox.apples = apples.parallelStream().filter(p).collect(toList());

        return appleBox;
    }

    public List<Apple> getApples() {
        return apples;
    }

    public static void prettyPrintApple(List<Apple> apples, AppleFormatter formatter) {
        for (Apple apple : apples) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

}
