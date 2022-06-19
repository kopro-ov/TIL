package effectiveJava.chapter01.item03;

public class Elvis2 {

    private static final Elvis2 INSTANCE = new Elvis2();
    private Elvis2() {}
    public static Elvis2 getInstance() { return INSTANCE; }

    public void leaveTheBuild() {}

}
