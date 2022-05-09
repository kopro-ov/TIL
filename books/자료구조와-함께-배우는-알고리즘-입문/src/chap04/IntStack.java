package chap04;

public class IntStack {

    private int max;
    private int ptr;
    private int[] stk;

    //실행 시 예외 : 스택이 비어 있음
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() { }
    }

    //실행 시 예외 : 스택이 가득 참
    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() { }
    }

    //생성자
    public IntStack(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stk = new int[max];        // 스택 본체용 배열을 생성
        } catch (OutOfMemoryError e) { //생성할 수 없음
            max = 0;
        }
    }

    //스택에 x를 푸시
    public int push(int x) throws OverflowIntStackException {
        if (ptr >= max) {
            throw new OverflowIntStackException(); //스택이 가득차면 예외 던짐
        }
        return  stk[ptr++] = x;
    }

    //스택에서 데이터를 팝
    public int pop() throws EmptyIntStackException {
        if (ptr <= 0) {
            throw new EmptyIntStackException();
        }
        return stk[--ptr];
    }

    //스택에서 데이터를 피크
    public int peek() throws EmptyIntStackException {
        if (ptr <= 0) {
            throw new EmptyIntStackException();
        }
        return stk[ptr - 1];
    }


    //스택에서 x를 찾아 인덱스(없으면 -1)반환
    public int indexOf(int x) {
        for (int i = ptr -1; i >= 0; i--) {
            if (stk[i] == x)
                return i;
        }
        return -1;
    }

    public void clear() {
        ptr = 0;
    }

    //스택의 용량 반환
    public int capacity() {
        return max;
    }

    //스택에 쌓여 있는 데이터 수를 반환
    public int size() {
        return ptr;
    }


}
