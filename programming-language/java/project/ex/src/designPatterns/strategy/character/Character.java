package designPatterns.strategy.character;

import designPatterns.strategy.weapon.WeaponBehavior;

public abstract class Character {

    WeaponBehavior weapon;

    public void fight() {
        weapon.useWeapon();
    }

    public void setWeapon(WeaponBehavior wb) {
        this.weapon = wb;
    }

}
