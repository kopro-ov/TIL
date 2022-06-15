package designPatterns.strategy.weapon;

public class BowAndArrowBehavior implements WeaponBehavior{

    @Override
    public void useWeapon() {
        System.out.println("화살로 슉슉");
    }
}
