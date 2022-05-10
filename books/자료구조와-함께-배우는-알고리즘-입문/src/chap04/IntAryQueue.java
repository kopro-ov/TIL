package chap04;

public class IntAryQueue {

    private int max;        //큐 용량
    private int num;        //현재 데이터 수
    private int[] que;      //큐 본체

    public class EmptyIntAryQueueException extends RuntimeException {
        public EmptyIntAryQueueException() {}
    }
    public class OverflowIntAryQueueException extends RuntimeException {
        public OverflowIntAryQueueException() {}
    }

    public IntAryQueue(int capacity) {
        max = capacity;
        num = 0;
        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    //데이터를 넣는 작업 인큐
    public int enqueue(int x) {
        if (num >= max) {
            throw new OverflowIntAryQueueException();
        }
        que[num++] = x;
        return x;
    }

}
