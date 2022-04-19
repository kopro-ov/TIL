package chap01;

import java.util.Scanner;

public class Q16 {


    static void spira(int n) {

        for (int i = 1; i <= n; i++) {

            for (int j = i; j <= n-1 ; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < (i-1)*2+1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {


        Scanner stdIn = new Scanner(System.in);
        System.out.print("단을 입력하세요 : ");
        int n = stdIn.nextInt();

        spira(n);

    }
}
