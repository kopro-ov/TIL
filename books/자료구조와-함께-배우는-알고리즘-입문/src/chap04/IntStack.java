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

}
