package templateMethod.starBirds;

public abstract class CaffeineBeverage {

    /**
     * 서브클래스가 해당 메서드를 아무렇게나 오버라이드하지 못핳도록
     * final 선언
     */
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    abstract void brew();

    abstract void addCondiments();
    
    void boilWater() {
        System.out.println("물 끓이는 중");
    }

    void pourInCup() {
        System.out.println("컵에 따르는 중");
    }

}
