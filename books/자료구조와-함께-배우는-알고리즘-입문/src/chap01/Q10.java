package chap01;

import java.util.Scanner;

public class Q10 {

    public static void main(String[] args) {


        Scanner stdIn = new Scanner(System.in);
        System.out.println("a의 값 : ");
        int a = stdIn.nextInt();
        int b;

        do {
            System.out.println("b의 값 : ");
            b = stdIn.nextInt();
            if(a >= b) {
                System.out.println("a보다 큰 값을 입력하세요.");
            }
        }while (a>=b);

        System.out.printf("b - a는 %d입니다", b-a);



    }
}
