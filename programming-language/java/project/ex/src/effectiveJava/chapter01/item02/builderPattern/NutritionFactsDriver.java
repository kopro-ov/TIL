package effectiveJava.chapter01.item02.builderPattern;

public class NutritionFactsDriver {

    public static void main(String[] args) {

        /**
         * 빌더 패턴
         * 클라이언트 코드는 쓰기 쉽고 무엇보다도 읽기 쉽다
         */
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .carbohydrate(100).sodium(35).carbohydrate(27).build();
    }
}
