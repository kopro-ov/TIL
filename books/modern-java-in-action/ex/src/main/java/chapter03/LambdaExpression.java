package chapter03;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class LambdaExpression {

    public static void main(String[] args) {

        List<String> str = Arrays.asList("a", "b", "c", "d");

        // str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        str.sort(String::compareToIgnoreCase);

        ToIntFunction<String> stringToInt = (String s) -> Integer.parseInt(s);
        ToIntFunction<String> stringToIn2 = Integer::parseInt;

        BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
        BiPredicate<List<String>, String> contains2 = List::contains;

    }

}
