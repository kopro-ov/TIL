package effectiveJava.chapter01.item05;

import java.util.ArrayList;
import java.util.List;

public class SpellCheckerEx1 {
    private static final Lexicon dictionary = new TestLexicon();

    //객체 생성 방지
    private SpellCheckerEx1() {}

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
