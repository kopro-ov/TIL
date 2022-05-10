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


    //큐에서 x를 찾아 인덱스(없으면 -1)반환
    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            if (que[i] == x)
                return i;
        }
        return -1;
    }

    //큐 초기화
    public void clear() {
        num = 0;
    }

    //큐의 용량 반환
    public int capacity() {
        return max;
    }

    //큐에 쌓여 있는 데이터 수를 반환
    public int size() {
        return num;
    }

    //큐가 비어 있는가?
    public boolean isEmpty() {
        return num <= 0;
    }

    //큐가 가득 찼는지 검사하는 메서드 isFull
    public boolean isFull() {
        return num >= max;
    }

    //큐 안에 있는 모든 데이터를 표시하는 메서드
    public void dump() {
        if (num <= 0) {
            System.out.println("큐가 비어 있습니다.");
        } else {
            for (int i = 0; i < num; i++) {
                System.out.print(que[i]+ " ");
            }
            System.out.println();
        }
    }
}
