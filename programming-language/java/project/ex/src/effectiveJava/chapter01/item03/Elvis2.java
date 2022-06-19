package effectiveJava.chapter01.item03;

import java.io.Serializable;

public class Elvis2 implements Serializable {

    private static final Elvis2 INSTANCE = new Elvis2();
    private Elvis2() {}
    public static Elvis2 getInstance() { return INSTANCE; }

    public void leaveTheBuild() {}


    private Object readResolve() {
        return INSTANCE;
    }

}
