package designPatterns.strategy.character;

import designPatterns.strategy.weapon.SwordBehavior;

public class King extends Character {

    public King() {
        weapon = new SwordBehavior();
    }

}
