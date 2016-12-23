package studaout.array;

import java.util.Optional;

/**
 * http://www.geeksforgeeks.org/search-an-element-in-an-array-where-difference-between-adjacent-elements-is-1/
 * Given an array where difference between adjacent elements is 1, write an algorithm to search for an element in
 * the array and return the position of the element (return the first occurrence).
 */
public class ElementWithAdjacentDiff1 {

    public static Optional<Integer> findNaive(int [] arr) {
        if ( arr.length < 3 ) return Optional.empty();
        for ( int i = 1; i < arr.length-1; ++i) {
            int l = Math.abs(arr[i] - arr[i - 1]);
            int r = Math.abs(arr[i]-arr[i+1]);
            if ( l == 1 && r == 1  ) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    public static Optional<Integer> find(int [] arr) {
        if ( arr.length < 3 ) return Optional.empty();
        int i = 1;
        int last = arr.length-1;
        while ( i < last ) {
            int l = Math.abs(arr[i] - arr[i - 1]);
            int r = Math.abs(arr[i]-arr[i+1]);
            if ( l == 1 && r == 1  ) {
                return Optional.of(i);
            } else if ( r != 1 ) {
                i += 2;
            } else {
                i += 1;
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        int arr[] = {1, 8 ,8, 6, 7, 6, 5, 4, 3, 2, 3, 4, 3 };
        //int arr[] = {1, 1 , 1, 1 };
        Optional<Integer> res = findNaive(arr);
        if ( res.isPresent() ) {
            int i = res.get();
            System.out.println(arr[i-1] + " : " + arr[i] + " : " + arr[i+1]);
        } else {
            System.out.println("not found");
        }
        res = find(arr);
        if ( res.isPresent() ) {
            int i = res.get();
            System.out.println(arr[i-1] + " : " + arr[i] + " : " + arr[i+1]);
        } else {
            System.out.println("not found");
        }

    }
}
