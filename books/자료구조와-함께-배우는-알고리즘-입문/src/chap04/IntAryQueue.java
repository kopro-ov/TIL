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
            //큐가 꽉참
            throw new OverflowIntAryQueueException();
        }
        que[num++] = x;
        return x;
    }

    //데이터를 꺼내는 작업 디큐
    public int dequeue() {
        if (num <= 0) {
            //큐가 비어있음
            throw new EmptyIntAryQueueException();
        }
        int x = que[0];
        for (int i = 0; i < num -1; i++) {
            que[i] = que[i-1];
        }
        num--;
        return x;
    }
}
