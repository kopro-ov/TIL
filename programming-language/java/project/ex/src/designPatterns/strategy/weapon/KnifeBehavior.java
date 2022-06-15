package designPatterns.strategy.weapon;

public class KnifeBehavior implements WeaponBehavior{

    @Override
    public void useWeapon() {
        System.out.println("칼로 슉슉");
    }
}
