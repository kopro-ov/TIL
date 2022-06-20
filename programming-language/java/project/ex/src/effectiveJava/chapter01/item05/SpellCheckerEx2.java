package effectiveJava.chapter01.item05;

import java.util.ArrayList;
import java.util.List;

public class SpellCheckerEx2 {

    private final Lexicon dictionary = new TestLexicon();

    //객체 생성 방지
    private SpellCheckerEx2() {}
    public static SpellCheckerEx2 INSTANCE = new SpellCheckerEx2();

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
