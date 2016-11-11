package studaout.array;

import studaout.Pair;

import java.util.HashMap;
import java.util.Optional;

/**
 * https://leetcode.com/problems/two-sum/
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 * Example: Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    public static Optional<Pair<Integer,Integer>> addBruteForce(int target, int [] arr) {
        if ( arr == null || arr.length < 2 ) return Optional.empty();
        for ( int i = 0; i < arr.length-1; ++i ) {
            for ( int j = i+1; j < arr.length; ++j ) {
                if ( arr[i] + arr[j] == target ) return Optional.of(Pair.create(i,j));
            }
        }
        return Optional.empty();
    }

    public static Optional<Pair<Integer,Integer>> addWitHash(int target, int [] arr) {
        if ( arr == null || arr.length < 2 ) return Optional.empty();
        HashMap<Integer, Integer> h = new HashMap<>();
        for ( int i = 0; i < arr.length-1; ++i ) {
            int a = target - arr[i];
            if ( h.containsKey(a) ) {
                return Optional.of(Pair.create(h.get(a), i));
            }
            h.putIfAbsent(arr[i], i); //if already there we can ignore since we can use the first one
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        int arr[] = {2,7,9,15,3,4,1};
        addBruteForce(10, arr).ifPresent( p ->
                System.out.println("arr[" + p.first + "] + arr[" + p.second + "] = " +
                        arr[p.first] + " + " + arr[p.second] + " = " + (arr[p.first] + arr[p.second]) ));
        addWitHash(10, arr).ifPresent( p ->
                System.out.println("arr[" + p.first + "] + arr[" + p.second + "] = " +
                        arr[p.first] + " + " + arr[p.second] + " = " + (arr[p.first] + arr[p.second]) ));
    }
}
