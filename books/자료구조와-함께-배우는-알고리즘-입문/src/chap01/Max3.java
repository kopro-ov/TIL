package chap01;

import java.util.Scanner;

public class Max3 {

    static int max3(int a, int b, int c) {
        int max = a;

        if(b > max)
            max = b;
        if(c > max)
            max = c;

        return max;
    }

    static int max4(int a, int b, int c, int d) {
        int max = a;

        if(b > max)
            max = b;
        if(c > max)
            max = c;
        if(d > max)
            max = d;

        return max;
    }

    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        System.out.println("세 정수의 최댓값을 구합니다.");
        System.out.println("a의 값 : ");
        int a = stdIn.nextInt();

        System.out.println("b의 값 : ");
        int b = stdIn.nextInt();

        System.out.println("c의 값 : ");
        int c = stdIn.nextInt();

        System.out.println(max3(a, b, c));

    }

}
