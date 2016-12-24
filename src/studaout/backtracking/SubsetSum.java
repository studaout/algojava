package studaout.backtracking;

import studaout.Util;

import java.util.Arrays;
import java.util.LinkedList;

public class SubsetSum {

    public static void findWithSort(int k, int [] arr) {
        Arrays.sort(arr);
        findWithSort(0, k, 0, new LinkedList<>(), arr);
    }

    public static void findWithSort(int start, int k, int cur, LinkedList<Integer> set, int [] arr) {
        if ( cur == k ) {
            Util.print(set);
            return;
        } else if ( cur > k ) {
            return;
        }
        int n = arr.length;
        for (int i = start; i < n; ++i) {
            int v = arr[i];
            int nc = cur + v;
            set.add(v);
            find(i + 1, k, nc, set, arr);
            set.removeLast();
        }
    }


    public static void find(int k, int [] arr) {
        find(0, k, 0, new LinkedList<>(), arr);
    }

    public static void find(int start, int k, int cur, LinkedList<Integer> set, int [] arr) {
        if ( cur == k ) {
            Util.print(set);
//            return;
        }
        int n = arr.length;
        for (int i = start; i < n; ++i) {
            int v = arr[i];
            int nc = cur + v;
            set.add(v);
            find(i + 1, k, nc, set, arr);
            set.removeLast();
        }
    }

    public static void main(String[] args) {
        int arr[] = {10, 7, 5, 18, 12, 20, 15, 35, 0};
        find(35, arr);
        System.out.println("----------");
        findWithSort(35, arr);
    }
}
