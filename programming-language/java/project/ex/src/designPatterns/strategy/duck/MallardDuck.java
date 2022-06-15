package designPatterns.strategy.duck;

import designPatterns.strategy.fly.FlyWithWings;
import designPatterns.strategy.quack.Quack;

public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    void display() {
        System.out.println("저는 물오리입니다");
    }
}
