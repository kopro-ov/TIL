package chap02;

public class SumOfArray {

    static int sumOf(int[] a) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        int sum = sumOf(arr);

        System.out.println(sum);
    }

}
