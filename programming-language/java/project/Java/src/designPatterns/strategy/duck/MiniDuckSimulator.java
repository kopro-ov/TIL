package designPatterns.strategy.duck;

import designPatterns.strategy.fly.FlyRocketPowered;

public class MiniDuckSimulator {

    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.performQuack();
        mallardDuck.performFly();

        Duck rubberDuck = new RubberDuck();
        rubberDuck.performQuack();
        rubberDuck.performFly();

        rubberDuck.setFlyBehavior(new FlyRocketPowered());
        rubberDuck.performFly();

    }
}
