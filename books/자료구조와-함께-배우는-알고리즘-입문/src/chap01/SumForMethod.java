package chap01;

import java.util.Scanner;

public class SumForMethod {

    static int sumof(int a, int b) {
        int result = 0;
        for (int i = a; i <= b ; i++) {
            result += i;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        System.out.println("a부터 b까지의 정수 합을 구한다.");
        System.out.println("a값은 ? ");
        int a = stdIn.nextInt();
        System.out.println("b값은 ? ");
        int b = stdIn.nextInt();

        int sum = sumof(a, b);
        System.out.println(a+"부터 "+b+"의 합은 "+sum+"이다.");



    }

}
