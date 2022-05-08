package chap03;

import java.util.Comparator;

//클래스 X의 내부에서 comparator를 정의하는 방법은 다음과 같음
public class X {

    //필드, 메서드 등
    public static final Comparator<T> COMPARATOR = new Comp();

    private static class Comp implements  Comparator<T> {
        @Override
        public int compare(T d1, T d2) {
            //d1이 d2보다 크면 양의 값
            //d1이 d2보다 작으면 음의 값
            //d1이 d2와 같으면 0
            return 0;
        }
    }
}
