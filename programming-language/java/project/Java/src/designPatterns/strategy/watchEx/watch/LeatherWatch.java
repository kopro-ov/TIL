package designPatterns.strategy.watchEx.watch;

import designPatterns.strategy.watchEx.strap.LeatherStrap;

public class LeatherWatch extends Watch{

    public LeatherWatch() {
        strap = new LeatherStrap();
    }

    @Override
    void display() {
        System.out.println("가죽 시계");
    }
}
