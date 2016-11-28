package studaout.array;

import studaout.Pair;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * Given n non-negative integers a1, a2, ..., an, where each represents
 * a point at coordinate (i, ai). n vertical lines are drawn such that the
 * two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
 * with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container.
 */
public class ContainerWithMostWater {

    public static Pair<Integer, Integer> findBruteForce(int [] arr) {
        int i1 = 0, i2 = 0;
        int maxSq = 0;
        for ( int i = 0; i < arr.length-1; ++i ) {
            for ( int j = i+1; j < arr.length; ++j ) {
                int min = Math.min(arr[i], arr[j]);
                int s = min * (j-i);
                if ( s > maxSq ) {
                    maxSq = s;
                    i1 = i;
                    i2 = j;
                }
            }
        }
        return Pair.create(i1,i2);
    }

    public static Pair<Integer, Integer> find(int [] arr) {
        int i = 0, j = arr.length-1;
        int i1 = i, i2 = j;
        int sq = 0;
        while ( i < j ) {
            int s = arr[i]*(j-i);
            if ( s > sq ) {
                sq = s;
                i1 = i;
                i2 = j;
            }
            if ( arr[i] <= arr[j] ) {
                i += 1;
            } else {
                j -= 1;
            }

        }
        return Pair.create(i1,i2);
    }

    public static void print(Pair<Integer,Integer> res, int [] arr) {
        int min = Math.min(arr[res.first], arr[res.second]);
        int sq = min * (res.second - res.first);
        System.out.printf("x=[%d,%d] y=[%d,%d], square=%d \n",
                res.first, arr[res.first],
                res.second, arr[res.second],
                sq
                );
    }

    public static void main(String[] args) {
        int [] arr = {1,1,2,1,5,7,5,1,1,7,3,6,2};
        Pair<Integer,Integer> res = findBruteForce(arr);
        print(res, arr);
        res = find(arr);
        print(res, arr);
    }
}
