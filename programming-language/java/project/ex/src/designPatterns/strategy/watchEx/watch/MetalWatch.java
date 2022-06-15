package designPatterns.strategy.watchEx.watch;

import designPatterns.strategy.watchEx.strap.MetalStrap;

public class MetalWatch extends Watch {

    public MetalWatch() {
        strap = new MetalStrap();
    }

    @Override
    void display() {
        System.out.println("메탈 시계");
    }
}
