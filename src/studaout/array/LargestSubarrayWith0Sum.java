package studaout.array;

import java.util.HashMap;

/**
 * http://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
 */
public class LargestSubarrayWith0Sum {

    public static int findNaive(int [] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; ++i){
            int sum = 0;
            for (int j = i; j < arr.length; j++ ) {
                sum += arr[j];
                if ( sum == 0 ) {
                    int s = j-i+1;
                    if ( s > max ) max = s;
                }
            }
        }
        return max;
    }

    public static int findHash(int [] arr) {
        int max = 0;
        int s = 0;
        HashMap<Integer,Integer> m = new HashMap<>();
        for( int i = 0; i < arr.length; ++i ) {
            s +=arr[i];
            if ( arr[i] == 0 && max == 0 ) max = 1;
            if ( s == 0 ) {
                max = i+1;
            }
            Integer c = m.get(s);
            if ( c != null ) {
                int l = i - c;
                if ( l > max ) max = l;
            } else {
                m.put(s, i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int [] arr1 = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(findNaive(arr1));
        System.out.println(findHash(arr1));
        System.out.println("-------------------");
        int [] arr2 = {1, 2, 3};
        System.out.println(findNaive(arr2));
        System.out.println(findHash(arr2));
        System.out.println("-------------------");
        int [] arr3 = {1, 0, 3};
        System.out.println(findNaive(arr3));
        System.out.println(findHash(arr3));
        System.out.println("-------------------");
    }
}
