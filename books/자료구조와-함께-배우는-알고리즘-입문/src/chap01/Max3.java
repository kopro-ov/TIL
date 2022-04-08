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

    static int min3(int a, int b, int c) {
        int min = a;

        if(b < min)
            min = b;
        if(c < min)
            min = c;

        return min;
    }

    static int min4(int a, int b, int c, int d) {
        int min = a;

        if(b < min)
            min = b;
        if(c < min)
            min = c;
        if(d < min)
            min = d;

        return min;
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

        System.out.println(min3(a, b, c));

    }

}
