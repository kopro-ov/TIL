package templateMethod.starBirds;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@DisplayName("커피 후크 테스트")
public class CoffeeWithHookTest {

    CoffeeWithHook coffeeWithHook;

    @BeforeEach
    public void init() {
        coffeeWithHook = new CoffeeWithHook();
    }


    @DisplayName("우유와 설탕 추가")
    @Test
    void GivenY_whenCustomerCoffeePrepareRecipe() {
        // Given
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("y".getBytes());
        System.setIn(in);

        // When & Then
        coffeeWithHook.prepareRecipe();
    }

    @DisplayName("우유와 설탕 추가 안함")
    @Test
    void GivenN_whenCoffeePrepareRecipe() {
        // Given
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("n".getBytes());
        System.setIn(in);

        // When & Then
        coffeeWithHook.prepareRecipe();
    }

}
