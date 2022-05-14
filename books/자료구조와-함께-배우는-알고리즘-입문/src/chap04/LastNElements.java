package chap04;

import java.util.Scanner;

//원하는 개수만큼 값을 입력 받아 요솟수가 N인 배열에 마지막 N개를 저장
public class LastNElements {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        final int N = 10;
        int[] a = new int[N];  //입력 받을 값을 저장
        int cnt = 0;           //입력 받을 개수
        int retry;             //다시 한 번?

        System.out.println("정수를 입력하세요.");

        do {
            System.out.printf("%d번째 정수 : ",cnt+1);
            a[cnt++ % N] = stdIn.nextInt();
            System.out.print("계속 할까요? (예.1 / 아니오 0.");
            retry = stdIn.nextInt();
        } while (retry == 1);

    }

}
