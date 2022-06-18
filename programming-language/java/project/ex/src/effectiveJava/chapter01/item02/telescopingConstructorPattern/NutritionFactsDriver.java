package effectiveJava.chapter01.item02.telescopingConstructorPattern;

public class NutritionFactsDriver {

    public static void main(String[] args) {

        /**
         * 점층적 생서자 패턴
         * 매개변수 개수가 많아지면 클라이언트 소스를 읽기 어렵다!
         */
        NutritionFacts nutritionFacts1 = new NutritionFacts(240, 8);
        NutritionFacts nutritionFacts2 = new NutritionFacts(240, 8, 100);
        NutritionFacts nutritionFacts3 = new NutritionFacts(240, 8, 100, 0);
        NutritionFacts nutritionFacts4 = new NutritionFacts(240, 8, 100, 0, 35);
        NutritionFacts nutritionFacts5 = new NutritionFacts(240, 8, 100, 0, 35,27);

    }
}
