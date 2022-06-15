package designPatterns.strategy.weapon;

public class SwordBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("검으로 숑숑");
    }
}
