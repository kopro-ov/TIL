package designPatterns.strategy.fly;

public class FlyWithWings implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("파닥파닥");
    }
}
