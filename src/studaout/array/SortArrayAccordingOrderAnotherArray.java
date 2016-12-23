package studaout.array;

import studaout.Util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * http://www.geeksforgeeks.org/sort-array-according-order-defined-another-array/
 * Given two arrays A1[] and A2[], sort A1 in such a way that the relative order among
 * the elements will be same as those are in A2. For the elements not present in A2,
 * append them at last in sorted order.
 * Input: A1[] = {12, 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}
 *  A2[] = {2, 1, 8, 3}
 *  Output: A1[] = {2, 2, 1, 1, 8, 8, 3, 5, 6, 7, 9, 12}
 */
public class SortArrayAccordingOrderAnotherArray {

    public static int [] sort(int [] arr, int [] order) {
        return arr;
    }

    public static int [] sortHash(int [] arr, int [] order) {
        HashMap<Integer, Integer> map = new HashMap<>(arr.length+4);
        Arrays.stream(arr).forEach( i-> {
            Integer c = map.get(i);
            c = ( c == null ) ? 1 : c+1;
            map.put(i, c);
        });
        int i = 0;
        for ( int v : order ) {
            Integer c = map.get(v);
            if ( c != null ) {
                while ( c > 0 ) {
                    arr[i] = v;
                    ++i;
                    c = c-1;
                }
                map.remove(v);
            }
        }
        int s = i;
        for (Map.Entry<Integer, Integer> e : map.entrySet() ) {
            Integer c = e.getValue();
            Integer v = e.getKey();
            while ( c > 0 ) {
                arr[i] = v;
                ++i;
                c = c-1;
            }
        }
        Arrays.sort(arr, s, arr.length);
        return arr;
    }

    public static int [] sortComparator(int [] arr, int [] order) {
        //TODO:
        return arr;
    }

    public static void main(String[] args) {
        int [] arr = {12, 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int [] order = {2, 1, 8, 3};
        Util.print(sortHash(arr, order));
    }
}
