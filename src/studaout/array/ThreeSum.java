package studaout.array;

import java.util.*;

/**
 * 3Sum
 * https://leetcode.com/problems/3sum/
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 *  A solution set is:
 *  [ [-1, 0, 1], [-1, -1, 2] ]
 */
public class ThreeSum {

    public static List<List<Integer>> find(int [] arr) { //does not solve duplicates
        List<List<Integer>> res = new LinkedList<>();
        HashMap<Integer, Integer> firstHead = new HashMap<>();
        for ( int i = 0; i < arr.length-2; ++i) {
            int s = arr[i];
            if ( firstHead.containsKey(s) ) continue;
            firstHead.put(s, -1);
            int target = -s;
            HashMap<Integer, Integer> h = new HashMap<>();
            for ( int j = i+1; j < arr.length; ++j ) {
                int a = target - arr[j];
                if ( h.getOrDefault(a,-1) == 0 ) {
                    res.add(Arrays.asList(s, a, arr[j]));
                    h.put(a, -1);
                }
                h.putIfAbsent(arr[j], 0); //if already there we can ignore since we can use the first one
            }
        }
        return res;
    }

    public static List<List<Integer>> findSorted(int [] arr) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            if (i == 0 || arr[i] > arr[i - 1]) {
                int j = i + 1;
                int k = arr.length - 1;
                while (j < k) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        res.add(Arrays.asList(arr[i], arr[j], arr[k]));
                        j++;
                        k--;
                        while (j < k && arr[j] == arr[j - 1]) j++; //duplicates since it was sorted
                        while (j < k && arr[k] == arr[k + 1]) k--;
                    } else if (arr[i] + arr[j] + arr[k] < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return res;
    }

    public static void print(List<List<Integer>> list) { //:)
        list.stream().map( (l) -> {
            StringJoiner s = new StringJoiner(",", "[","]");
            l.forEach( i -> s.add(i.toString()));
            return s.toString();
        }).forEach(System.out::println);
    }

    public static void main(String[] args) {
        int [] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = findSorted(arr);
        print(res);
    }
}
