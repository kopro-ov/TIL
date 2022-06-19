package effectiveJava.chapter01.item03;

public class ElvisDriver {

    public static void main(String[] args) {

        Elvis elvis = Elvis.INSTANCE;
        System.out.println(elvis);

        Elvis2 elvis2 = Elvis2.getInstance();
        System.out.println(elvis2);

        System.out.println(Elvis3.INSTANCE);
    }
}
