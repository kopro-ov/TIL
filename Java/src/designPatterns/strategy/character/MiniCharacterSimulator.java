package designPatterns.strategy.character;

import designPatterns.strategy.weapon.AxeBehavior;

public class MiniCharacterSimulator {

    public static void main(String[] args) {
        Character queen = new Queen();
        queen.fight();

        Character king = new King();
        king.fight();

        king.setWeapon(new AxeBehavior());
        king.fight();
    }
}
