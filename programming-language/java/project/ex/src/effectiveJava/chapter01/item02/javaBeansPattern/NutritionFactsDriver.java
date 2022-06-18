package effectiveJava.chapter01.item02.javaBeansPattern;

public class NutritionFactsDriver {

    public static void main(String[] args) {

        /**
         * 자바빈즈 패턴
         * 객체 하나를 만들려면 메서드를 여러개 호출해야 하고,
         * 객체가 완전히 생성되기 전까지는 일관성이 무너진 상태에 놓이게 된다
         */
        NutritionFacts cocaCola = new NutritionFacts();
        cocaCola.setServingSize(240);
        cocaCola.setServings(8);
        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);

    }
}
