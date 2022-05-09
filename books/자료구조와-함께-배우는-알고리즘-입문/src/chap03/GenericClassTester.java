package chap03;

public class GenericClassTester {

    //제너릭 클래스의 파라미터를 T라고 작성합니다.
    static class GenericClass<T> {
        private T xyz;
        GenericClass(T t) {
            this.xyz = t;
        }
        T getXyz() {
            return xyz;
        }
    }

}
