package designPatterns.strategy.duck;

import designPatterns.strategy.fly.FlyNoWay;
import designPatterns.strategy.quack.Squeak;

public class RubberDuck extends Duck{

    public RubberDuck() {
        quackBehavior = new Squeak();
        flyBehavior = new FlyNoWay();
    }

    @Override
    void display() {
        System.out.println("저는 고무 오리입니다");
    }
}
