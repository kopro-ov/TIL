package chap04;

public class IntQueue {

    private int max; //큐의 용량
    private int front; //첫 번째 요소 커서
    private int rear; //마지막 요소 커서
    private int num; //현재 데이터 수
    private int[] que; //큐 본체

    //실행 시 예외 : 큐가 비어있음
    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {}
    }

    //실행 시 예외 : 큐가 가득참
    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {}
    }

    //생성자
    public IntQueue(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    //큐에 데이터를 인큐
    public int enque(int x) throws OverflowIntQueueException {
        if (num >= max)
            throw new OverflowIntQueueException();
        que[rear++] = x;
        num++;
        if (rear == max)
            rear = 0;
        return x;
    }

    //큐에서 데이터를 디큐
    public int deque() throws EmptyIntQueueException {
        if (num <= 0)
            throw new EmptyIntQueueException();
        int x = que[front++];
        num--;
        if (front == max)
            front = 0;
        return x;
    }

}
