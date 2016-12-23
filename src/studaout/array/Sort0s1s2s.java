package studaout.array;

import java.util.Arrays;

public class Sort0s1s2s {

    public static int [] sort1(int [] arr) {
        int n = arr.length;
        int i = 0, j = n-1;
        while ( i < j ) {
            if ( arr[i] > 0 && arr[j] == 0 ) {
                arr[j] = arr[i];
                arr[i] = 0;
            }
            if ( arr[i] == 0 ) ++i;
            if ( arr[j] > 0 ) --j;
        }
        j = n-1;
        while ( i < j ) {
            if ( arr[i] == 2 && arr[j] == 1 ) {
                arr[j] = arr[i];
                arr[i] = 1;
            }
            if ( arr[i] == 1 ) ++i;
            if ( arr[j] == 2 ) --j;
        }
        return arr;
    }

    public static int [] sort2(int [] arr) {
        int n = arr.length;
        int lo = 0;
        int hi = n-1;
        while (arr[lo] == 0) ++lo;
        int mid = lo;
        while (arr[mid] == 1 ) ++mid;
        while (arr[hi] == 2 ) --hi;
        while (mid <= hi) {
            if ( arr[mid] == 2 ) {
                arr[mid] = arr[hi];
                arr[hi] = 2;
                --hi;
            }
            if ( arr[mid] == 0 ) {
                arr[lo] = 0;
                arr[mid] = 1;
                ++lo;
            }
            if ( arr[mid] == 1 ) ++mid;
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {2, 2, 2, 0, 2, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1, 2};
        int arr1[] = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(sort1(arr1)));
        arr1 = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(sort2(arr1)));
    }

}
