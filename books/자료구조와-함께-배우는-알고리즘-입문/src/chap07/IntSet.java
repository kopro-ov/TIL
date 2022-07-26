package chap07;

public class IntSet {

    private int max;    // 집합의 최대 개수
    private int num;    // 집합의 요소 개수
    private int[] set;  // 집합 본체

    public IntSet(int capacity) {
        num = 0;
        max = capacity;
        try {
            set = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    // 집합의 최대 개수
    public int capacity() {
        return max;
    }

    // 집합의 요소 개수
    public int size() {
        return num;
    }
}
