package designPatterns.strategy.watchEx;

import designPatterns.strategy.watchEx.strap.LeatherStrap;
import designPatterns.strategy.watchEx.strap.MetalStrap;
import designPatterns.strategy.watchEx.watch.AppleWatch;
import designPatterns.strategy.watchEx.watch.LeatherWatch;
import designPatterns.strategy.watchEx.watch.MetalWatch;
import designPatterns.strategy.watchEx.watch.Watch;

public class MiniWatchSimulator {

    public static void main(String[] args) {
        Watch leatherWatch = new LeatherWatch();
        leatherWatch.getStrapType();
        leatherWatch.getNowTime();

        Watch metalWatch = new MetalWatch();
        metalWatch.getStrapType();
        metalWatch.getNowTime();

        Watch appleWatch = new AppleWatch();
        appleWatch.setStrap(new LeatherStrap());
        appleWatch.getStrapType();

        appleWatch.setStrap(new MetalStrap());
        appleWatch.getStrapType();

    }
}
