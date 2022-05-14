package chap04;

public class Gqueue<E> {

    private int max;
    private int num;
    private int front;
    private int rear;
    private E[] que;

    public static class EmptyGqueueException extends RuntimeException {
        public EmptyGqueueException() {}
    }

    // 실행 시 예외: 큐가 가득 참
    public static class OverflowGqueueException extends RuntimeException {
        public OverflowGqueueException() {}
    }

    public Gqueue(int capacity) {
        int max = capacity;
        try {
            que = (E[]) new Object[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public E enque(E x) throws OverflowGqueueException {
        if (num >= max)
            throw new OverflowGqueueException();
        que[rear++] = x;
        num++;
        if (rear == max)
            rear = 0;
        return x;
    }

    public E deque() throws EmptyGqueueException {
        if (num < 0)
            throw new EmptyGqueueException();
        E x = que[front++];
        num--;
        if (front == max)
            front = 0;
        return x;
    }

    public E peek() throws EmptyGqueueException {
        if (num < 0)
            throw new EmptyGqueueException();
        return que[front];
    }

    public int indexOf(E x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % max;
            if (que[idx] == x)
                return idx;
        }
        return -1;
    }

    public void clear() {
        num = front = rear = 0;
    }

    public int capacity() {
        return max;
    }


    public int size() {
        return num;
    }

    public boolean isFull() {
        return num >= max;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public void dump() {
        if (num < 0)
            System.out.println("큐가 비어있습니다.");
        else {
            for (int i = 0; i < num; i++)
                System.out.println(que[(i + front) % max] + " ");
            System.out.println();
        }
    }

}