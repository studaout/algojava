package studaout.array;

import java.util.HashMap;

/**
 * http://www.geeksforgeeks.org/longest-consecutive-subsequence/
 * Given an array of integers, find the length of the longest sub-sequence such that elements
 * in the subsequence are consecutive integers, the consecutive numbers can be in any order.
 * Examples
 *  Input: arr[] = {1, 9, 3, 10, 4, 20, 2};
 * Output: 4
 * The subsequence 1, 3, 4, 2 is the longest subsequence of consecutive elements
 */
public class LongestConsecutiveSubsequence {

    public static int find(int [] arr) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for ( int i : arr ) m.put(i,i);
        int size = 1;
        for ( int i : arr ) {
            if ( m.containsKey(i-1) ) continue;
            int curSize = 1;
            int cur = i+1;
            while ( m.containsKey(cur) ) {
                ++curSize;
                ++cur;
            }
            if ( curSize > size ) size = curSize;
        }
        return size;
    }

    public static void main(String[] args) {
        int arr [] =  {1, 9, 3, 10, 4, 20, 2};
        System.out.println(find(arr));
    }
}
