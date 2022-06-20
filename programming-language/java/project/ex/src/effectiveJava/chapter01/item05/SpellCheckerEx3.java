package effectiveJava.chapter01.item05;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SpellCheckerEx3 {

    private final Lexicon dictionary;

    public SpellCheckerEx3(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public static boolean isValid(String word) {
        return false;
    }
    public static List<String> suggestions(String typo) {
        List<String> result = new ArrayList<>();
        //맞춤법 검사 생략
        result.add(typo);
        return result;
    }

}
