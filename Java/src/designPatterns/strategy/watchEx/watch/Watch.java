package designPatterns.strategy.watchEx.watch;

import designPatterns.strategy.watchEx.strap.Strap;

import java.time.LocalTime;

public abstract class Watch {

    Strap strap;

    public void getNowTime() {
        LocalTime now = LocalTime.now();
        System.out.println("현재 시간은 "+now+"입니다.");
    }

    public void setStrap(Strap strap) {
        this.strap = strap;
    }

    public void getStrapType() {
        strap.strapType();
    }

    abstract void display();

}
