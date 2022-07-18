package templateMethod.starBirds;

public class Coffee {

    //커피 만드는 법
    void prepareRecipe() {
        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addSugarAndMilk();
    }

    private void boilWater() {
        System.out.println("물 끓이는 중");
    }

    private void brewCoffeeGrinds() {
        System.out.println("필터로 커피를 우려내는 중");
    }
    private void pourInCup() {
        System.out.println("컵에 따르는 중");
    }

    private void addSugarAndMilk() {
        System.out.println("설탕과 우유를 추가하는 중");
    }

}
