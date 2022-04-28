package chap02;

import java.util.Scanner;

public class CopyArray {

    static void copy(int[] a, int[] b) {
        for (int i = 0; i < b.length; i++) {
            a[i] = b[i];
        }
    }

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

    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        System.out.print("배열 b의 요솟수 : ");
        int nb = stdIn.nextInt();

        int[] a = new int[nb];
        int[] b = new int[nb];
        for (int i = 0; i < nb; i++) {
            System.out.print("b["+i+"] : ");
            b[i] = stdIn.nextInt();
        }

        copy(a, b);

        System.out.println("배열 b의 모든 요소를 배열 a에 복사");
        arrayOutput(a);


    }
}
