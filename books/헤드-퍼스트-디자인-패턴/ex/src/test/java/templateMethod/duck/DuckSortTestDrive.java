package templateMethod.duck;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@DisplayName("오리 정렬 테스트")
public class DuckSortTestDrive {

    @Test
    void givenDuckList_whenSortDucks() {
        // Given
        Duck[] ducks = {
                new Duck("Daffy", 8),
                new Duck("Dewey", 2),
                new Duck("Howard", 7),
                new Duck("Donald", 10),
                new Duck("Huey", 2)
        };

        System.out.println("정렬 전");
        display(ducks);

        // When & Then
        Arrays.sort(ducks);
        System.out.println("정렬 후");
        display(ducks);

    }

    void display(Duck[] ducks) {
        for (Duck d : ducks) {
            System.out.println(d);
        }

    }
}
