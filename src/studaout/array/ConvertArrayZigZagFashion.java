package studaout.array;

import studaout.Util;

/**
 * http://www.geeksforgeeks.org/convert-array-into-zig-zag-fashion/
 * Given an array of distinct elements, rearrange the elements of array in zig-zag fashion in O(n) time.
 * The converted array should be in form a < b > c < d > e < f.
 *  Example:
 * Input:  arr[] = {4, 3, 7, 8, 6, 2, 1}
 * Output: arr[] = {3, 7, 4, 8, 2, 6, 1}
 */
public class ConvertArrayZigZagFashion {

    public static int [] find(int arr[]) {
        int size = arr.length;
        if ( size  < 3 ) return arr;
        int i = 0;
        while ( i+2 < size ) {
            if ( arr[i+2] > arr[i+1] ) {
                int m = arr[i+2];
                arr[i+2] = arr[i+1];
                arr[i+1] = m;
            }
            if ( arr[i] > arr[i+1] ) {
                int m = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = m;
            }
            i+=2;
        }
        if ( (i + 1 < size) && ( arr[i] > arr[i+1]) ) {
            int m = arr[i + 1];
            arr[i + 1] = arr[i];
            arr[i] = m;
        }
        return arr;
    }

    public static void main(String[] args) {
        int  arr[] = {4, 3, 7, 8, 6, 2, 1, 6, 10, 4};
        Util.print(find(arr));
    }
}
