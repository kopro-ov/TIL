package adaptor.duck;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("오리 어댑터 테스트")
public class DuckTestDrive {

    @DisplayName("칠면조 객체를 오리 객체처럼 보이도록 만들기")
    @Test
    void givenTurkeyObject_whenRunDuckObject() {

        // Given
        Duck duck = new MallardDuck();

        Turkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        // When & Then
        System.out.println("칠면조가 말하길");
        turkey.gobble();
        turkey.fly();

        System.out.println("오리가 말하길");
        duck.quack();
        duck.fly();

        System.out.println("칠면조 어댑터가 말하길");
        turkeyAdapter.quack();
        turkeyAdapter.fly();

    }
}
