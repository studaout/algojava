package studaout.array;

import studaout.Util;
import studaout.IntPair;
import studaout.Pair;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/return-a-pair-with-maximum-product-in-array-of-integers/
 * Find a pair with maximum product in array of Integers : Given an array with both +ive and -ive integers, return a pair with highest product.
 * Examples:
 * Input: arr[] = {1, 4, 3, 6, 7, 0} : Output: {6,7}
 * Input: arr[] = {-1, -3, -4, 2, 0, -5} : Output: {-4,-5}
 */
public class FindPairWithMaximumProduct {

    public static IntPair findNaive(int arr[]) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        IntPair pair = null;
        for ( int i = 0; i < n-2; ++i ) {
            int m1 = arr[i];
            for (int j = i+1; j<n; ++j) {
                int m2 = arr[j];
                int r = m1 * m2;
                if ( r > max ) {
                    pair = new IntPair(m1, m2);
                    max = r;
                }
            }
        }
        return pair;
    }

    public static IntPair findSort(int arr[]) {
        int n = arr.length-1;
        Arrays.sort(arr);
        int m1 = arr[0]*arr[1];
        int m2 = arr[n]*arr[n-1];
        return (m1 > m2 ) ? new IntPair(arr[0], arr[1]) : new IntPair(arr[n], arr[n-1]);
    }

    public static IntPair find(int arr[]) {
        int n = arr.length;
        Integer firstPositive = 0;
        Integer secondPositive = 0;
        Integer firstNegative = 0;
        Integer secondNegative = 0;
        for (int v : arr) {
            if (v >= 0) {
                if (v > firstPositive) {
                    secondPositive = firstPositive;
                    firstPositive = v;
                } else if (v > secondPositive) {
                    secondPositive = v;
                }
            } else {
                if (v < firstNegative) {
                    secondNegative = firstNegative;
                    firstNegative = v;
                } else if (v < secondPositive) {
                    secondNegative = v;
                }
            }
        }
        return ( (firstPositive * secondPositive) > (firstNegative*secondNegative) ) ?
                new IntPair(firstPositive, secondPositive) : new IntPair(firstNegative, secondNegative);
    }


    public static void main(String[] args) {
        int [] arr1 = {1, 4, 3, 6, 7, 0};
        Util.print(arr1);
        System.out.println("naive: " + findNaive(arr1));
        System.out.println("effective: " + find(arr1));
        System.out.println("sort: " + findSort(arr1));
        //Output: {6,7}

        int [] arr2 = {-1, -3, -4, 2, 0, -5};
        Util.print(arr2);
        System.out.println("naive: " + findNaive(arr2));
        System.out.println("effective: " + find(arr2));
        System.out.println("sort: " + findNaive(arr2));
        //Output: {-4,-5}
    }
}
