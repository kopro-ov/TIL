package chap03;

//선행 검색(보초법)
public class SeqSearchSen {

    //요솟수가 n인 배열 a에서 key와 같은 요소를 보초법으로 선형 검색합니다.
    static int seqSearchSen(int[] a, int n, int key) {
        int i = 0;
        a[n] = key;         //보초 추가

        while (true) {
            if (a[i] == key)
                break;
            i++;
        }
        return i == n ? -1 : i;
    }

}
