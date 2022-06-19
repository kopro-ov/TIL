package effectiveJava.chapter01.item04;

public class UtilityClass {

    private UtilityClass() {
        throw new AssertionError();
    }

    public static int multiplication(int x) {
        return x * x;
    }


}
