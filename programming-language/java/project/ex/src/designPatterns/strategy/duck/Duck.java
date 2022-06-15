package designPatterns.strategy.duck;

import designPatterns.strategy.fly.FlyBehavior;
import designPatterns.strategy.quack.QuackBehavior;

public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void performQuack() {
        quackBehavior.quack();
    }

    void swim() {
        System.out.print("수영 해요");
    }

    abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void setFlyBehavior(FlyBehavior fb) {
        this.flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        this.quackBehavior = qb;
    }

}
