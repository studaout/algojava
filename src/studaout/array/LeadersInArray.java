package studaout.array;

import studaout.Util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * http://www.geeksforgeeks.org/leaders-in-an-array/
 */
public class LeadersInArray {

    public static Integer[] find(int [] arr) {
        List<Integer> l = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for ( int i =arr.length-1; i >=0; --i ) {
            int v = arr[i];
            if ( v > max ) {
                l.add(v);
                max = v;
            }
        }
        return l.toArray(new Integer[l.size()]);
    }

    public static void main(String[] args) {
        int [] arr = {16, 17, 4, 3, 5, 2};
        Util.print(find(arr));
    }
}
