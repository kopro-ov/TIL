package effectiveJava.chapter01.item03;

public class ElvisDriver {

    public static void main(String[] args) {

        //public static final 필드 방식의 싱글턴
        Elvis elvis = Elvis.INSTANCE;

        //정적 팩토리 방식의 싱글턴
        Elvis2 elvis2 = Elvis2.getInstance();

        //열거 타입 방식의 싱글턴
        System.out.println(Elvis3.INSTANCE);
    }
}
