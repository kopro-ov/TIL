package chap01;

import java.util.Scanner;

public class Q11 {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int num;

        do {
            System.out.println("숫자를 입력하세요.");
            num = stdIn.nextInt();
        }while (num<=0);

        System.out.println("그 수는 "+(int)( Math.log10(num)+1 )+"자리입니다.");

    }

}
