package adaptor.duck;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("칠면조 어댑터 테스트")
public class TurkeyTestDrive {

    @DisplayName("오리 객체를 칠면조 객체처럼 보이도록 만들기")
    @Test
    void givenDuckObject_whenRunTurkeyObject() {

        // Given
        Turkey turkey = new WildTurkey();

        Duck duck = new MallardDuck();

        DuckAdapter duckAdapter = new DuckAdapter(duck);

        // When & Then
        System.out.println("오리가 말하길");
        duck.quack();
        duck.fly();

        System.out.println("칠면조가 말하길");
        turkey.gobble();
        turkey.fly();

        System.out.println("오리 어댑터가 말하길");
        duckAdapter.gobble();
        duckAdapter.fly();
    }
}
