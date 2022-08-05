package chapter01.apple;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static chapter01.apple.Color.*;
import static org.junit.Assert.*;

public class AppleBoxTest {

    @Test
    public void 사과상자_생성() {

        // Given
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple.Builder(GREEN, 15).build());
        apples.add(new Apple.Builder(RED, 15).build());
        apples.add(new Apple.Builder(RED, 15).build());
        apples.add(new Apple.Builder(RED, 15).build());

        // When & Then
        AppleBox appleBox = AppleBox.createAppleBox(apples, (Apple a) -> GREEN.equals(a.getColor()));
        assertEquals("사과상자에는 사과가 1개여야 한다", 1, appleBox.getApples().size());

    }

}
