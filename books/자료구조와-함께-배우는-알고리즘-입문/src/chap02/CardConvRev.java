package chap02;

import java.util.Scanner;

public class CardConvRev {

    static int cardConvR(int x, int r, char[] d) {
        int digists = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do {
            d[digists++] = dchar.charAt(x % r);
            x /= r;
        }while (x != 0);
        return digists;
    }

    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);
        int no;                     // 변환하는 정수
        int cd;                     // 기수
        int dno;                    // 변환 후의 자릿수
        int retry;                  // 다시 한 번?
        char[] cno = new char[32];  // 변환 후 각 자리의 숫자를 넣어두는 문자의 배열

        System.out.println("10진수를 기수 변환합니다.");
        do {
            do {
                System.out.print("변환하는 음이 아닌 정수 : ");
                no = stdIn.nextInt();
            } while (no < 0);

            do {
                System.out.print("어떤 진수로 변환할까요? (2~36) : ");
                cd = stdIn.nextInt();
            } while (cd < 2 || cd > 36);

            dno = cardConvR(no, cd, cno);       //no를 cd진수로 변환

            System.out.print(cd + "진수로는 ");
            for (int i = dno -1; i >= 0; i--)   // 윗자리부터 차례로 나타냄
                System.out.print(cno[i]);
            System.out.println("입니다.");

            System.out.print("한 번 더 할까요 ?  (1.예/0.아니오) : ");
            retry = stdIn.nextInt();;
        } while (retry == 1);

    }

}
