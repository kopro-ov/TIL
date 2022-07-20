package templateMethod.starBirds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.IntStream;

@DisplayName("Tea 후크 테스트")
public class TeaWithHookTest {

    TeaWithHook teaWithHook;
    @BeforeEach
    public void init() {
        teaWithHook = new TeaWithHook();
    }

    @DisplayName("레몬 추가")
    @Test
    public void givenY_whenCustomerTeaPrepareRecipe() {

        // Given
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("y".getBytes());
        System.setIn(in);

        // When & Then
        teaWithHook.prepareRecipe();
    }

    @DisplayName("레몬 추가 안함")
    @Test
    public void givenN_whenTeaPrepareRecipe() {
        // Given
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("n".getBytes());
        System.setIn(in);

        // When & Then
        teaWithHook.prepareRecipe();
    }




}
