package chapter03;

public class RunnableEx {

    public static void process(Runnable r) {
        r.run();
    }

    public static void main(String[] args) {

        // 람다 사용
        Runnable r1 = () -> System.out.println("Hello World 1");

        // 익명 클래스 사용
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World 2");
            }
        };

        process(r1);
        process(r2);
        // 직접 전달된 람다 표현식
        process(() -> System.out.println("Hello World 3"));



    }

}
