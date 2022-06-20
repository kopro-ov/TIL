package effectiveJava.chapter01.item05;

public class SpellCheckerDriver {

    public static void main(String[] args) {

        //정적 유틸리와 싱글턴은 특수 어학용 사전으로 바꾸려면...
        SpellCheckerEx1.isValid("단어");
        SpellCheckerEx2.INSTANCE.isValid("단어");
        
        //테스트 사전
        SpellCheckerEx3 spellChecker = new SpellCheckerEx3(new TestLexicon());

        //특수 어학용 사전
        SpellCheckerEx3 spellChecker2 = new SpellCheckerEx3(new SpecialVocabularyLexicon());
    }

}
