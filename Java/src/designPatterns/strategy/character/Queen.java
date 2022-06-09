package designPatterns.strategy.character;

import designPatterns.strategy.weapon.AxeBehavior;

public class Queen extends Character{

    public Queen() {
        weapon = new AxeBehavior();
    }
}
