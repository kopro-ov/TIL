package chap01;

import java.util.Scanner;

public class Triangle {

    /**
     * 왼쪽 아래가 직각인 이등변 삼각형
     * @param n
     */
    static void triangleLB(int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 왼쪽 위가 직각인 이등변 삼각형
     * @param n
     */
    static void triangleLU(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 오른쪽 아래가 직각인 이등변 삼각형
     * @param n
     */
    static void triangleRB(int n) {

        for (int i = n; i > 0; i--) {
            for (int j = 1; j <= n; j++) {
                if(j >= i) {
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    /**
     * 오른쪽 위가 직각인 이등변 삼각형
     * @param n
     */
    static void triangleRU(int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if( i > j ) {
                    System.out.print(" ");
                }else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);
        System.out.println("숫자를 입력하세요. : ");
        int n = stdIn.nextInt();
        System.out.println("왼쪽 아래가 직각인 이등변 삼각형 출력");
        triangleLB(n);
        System.out.println("===============================");

        System.out.println("왼쪽 위가 직각인 이등변 삼각형 출력");
        triangleLU(n);
        System.out.println("===============================");

        System.out.println("오른쪽 아래가 직각인 이등변 삼각형 출력");
        triangleRB(n);
        System.out.println("===============================");

        System.out.println("오른쪽 위가 직각인 이등변 삼각형 출력");
        triangleRU(n);
        System.out.println("===============================");


    }

}
