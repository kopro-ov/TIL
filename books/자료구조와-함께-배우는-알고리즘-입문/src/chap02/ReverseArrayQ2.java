package chap02;

import java.util.Scanner;

public class ReverseArrayQ2 {

    static void arrayOutput(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if(i != a.length-1) {
                System.out.printf("%d ", a[i]);
            } else {
                System.out.printf("%d", a[i]);
            }
        }
        System.out.println();
    }

    static void swap(int[] a, int idx1, int idx2) {

        System.out.printf("a[%d]과 a[%d]를 교환합니다.\n\b", idx1, idx2);

        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void reverse(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            arrayOutput(a);
            swap(a, i, a.length - i - 1);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int[] x = {5, 10, 73, 2, -5, 42};

        reverse(x);

        System.out.println("역순 정렬을 마쳤습니다.");

    }

}
