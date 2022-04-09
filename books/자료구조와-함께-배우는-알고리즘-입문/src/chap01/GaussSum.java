package chap01;

import java.util.Scanner;

public class GaussSum {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("가우스의 덧셈이라는 방법을 이용하여 1부터 n까지의 정수합을 구한다.");

        int n = stdIn.nextInt();;

        System.out.println((1+n)*n/2);




    }
}
