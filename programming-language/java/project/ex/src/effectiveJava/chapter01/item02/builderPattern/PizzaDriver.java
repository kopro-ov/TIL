package effectiveJava.chapter01.item02.builderPattern;

import static effectiveJava.chapter01.item02.builderPattern.NyPizza.Size.SMALL;
import static effectiveJava.chapter01.item02.builderPattern.Pizza.Topping.*;

public class PizzaDriver {

    public static void main(String[] args) {

        /**
         * 빌더 패턴은 계층적으로 설계된 클래스와 함께 쓰기에 좋다
         * 빌더 패턴은 상당히 유연하다
         * 빌더를 이용하면 가변인수 매개변수를 여러 개 사용할 수 있다.
         */
        NyPizza nyPizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE)
                .addTopping(ONION)
                .build();

        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM)
                .sauceInside()
                .build();

    }
}
