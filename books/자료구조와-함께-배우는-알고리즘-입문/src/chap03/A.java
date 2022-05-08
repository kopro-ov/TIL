package chap03;

public class A implements Comparable<A> {

    @Override
    public int compareTo(A c) {
        //this가 c보다 크면 양의 값 반환
        //this가 c보다 작으면 음의 값 반환
        //this가 c와 같으면 0 반환
        return 0;
    }

    public boolean equals(Object c) {
        if(this == c) {
            return true;
        } else {
            return false;
        }
    }

}
