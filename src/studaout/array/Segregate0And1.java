package studaout.array;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/
 * You are given an array of 0s and 1s in random order. Segregate 0s on left side
 * and 1s on right side of the array. Traverse array only once.
 * Input array   =  [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
 * Output array =  [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]
 */
public class Segregate0And1 {

    public static int [] sort(int [] arr) {
        int n = arr.length;
        int i = 0, j = n-1;
        while ( i < j ) {
            if ( arr[i] == 1 && arr[j] == 0 ) {
                arr[i] = 0;
                arr[j] = 1;
            }
            if ( arr[i] == 0 ) ++i;
            if ( arr[j] == 1 ) --j;
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 1, 1, 1};
        System.out.println(Arrays.toString(sort(arr)));
    }
}
