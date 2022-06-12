package search;

import java.util.Arrays;

public class searchEx {

    static int searchLinear(int[] arr, int key) {
        int i = 0;
        while (true) {
            if(i== arr.length-1)
                return  -1;
            if(arr[i] == key)
                return i;
            i++;
        }
    }

    static int searchBinary(int[] arr, int key) {
        int firstIndex = 0;
        int lastIndex = arr.length-1;

        do {
            int searchIndex = (firstIndex + lastIndex) / 2;

            if (arr[searchIndex] == key)
                return searchIndex;
            else if(arr[searchIndex] < key) {
                firstIndex = searchIndex+1;
            } else {
                lastIndex = searchIndex-1;
            }
        } while (firstIndex <= lastIndex);

        return -1;
    }
    
    static int[] sorting(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int tmp;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {

        int[] intArray = new int[]{ 1, 8, 5, 2, 6, 3, 7, 4, 10, 9};

        searchLinear(intArray, 6);
        searchBinary(sorting(intArray), 6);

    }
}
