package studaout.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * Example 1:  nums1 = [1, 3],  nums2 = [2], The median is 2.0
 * Example 2: nums1 = [1, 2],  nums2 = [3, 4], The median is (2 + 3)/2 = 2.5
 */
public class MedianOf2SortedArrays {

    static class BruteForceFinder {

        final int[] a1;
        final int[] a2;

        BruteForceFinder(int[] arr1, int[] arr2) {
            a1 = arr1;
            a2 = arr2;
        }

        double find() {
            int size = a1.length + a2.length;
            boolean e = size % 2 == 0;
            int mid = (e) ? size / 2 - 1 : size / 2;
            int i = 0;
            int m = -1;
            int i1 = 0;
            int i2 = 0;
            while (i <= mid) {
                if (i1 >= a1.length) {
                    m = a2[i2];
                    i2 += 1;
                } else if (i2 >= a2.length) {
                    m = a1[i1];
                    i1 += 1;
                } else if (a1[i1] <= a2[i2]) {
                    m = a1[i1];
                    i1 += 1;
                } else {
                    m = a2[i2];
                    i2 += 1;
                }
                i += 1;
            }
            if (e) {
                if (i1 >= a1.length) {
                    return ((double) m + (double) a2[i2]) / 2;
                } else if (i2 >= a2.length) {
                    return ((double) m + (double) a1[i1]) / 2;
                } else if (a1[i1] <= a2[i2]) {
                    return ((double) m + (double) a1[i1]) / 2;
                } else {
                    return ((double) m + (double) a2[i2]) / 2;
                }
            } else {
                return m;
            }
        }
    }

    static class OptFinder {
        final int[] a1;
        final int[] a2;

        OptFinder(int[] arr1, int[] arr2) {
            a1 = (arr1.length <= arr2.length) ? arr1 : arr2;
            a2 = (arr1.length <= arr2.length) ? arr2 : arr1;
        }

        double find() {
            return find(0, a1.length - 1, 0, a2.length - 1);
        }

        double find(int x1, int x2, int y1, int y2) {
            int s1 = x2-x1 + 1;
            int s2 = y2-y1 + 1;
            if ( s1 == 1 ) {
                if ( s2 == 1 ) return (a1[x1] + a2[y1])/2d;
                if ( s2 == 2 ) return median(a1[x1], a2[y1], a2[y2]);
                int ym = y1 + s2/2;
                if ( s2 % 2 != 0 ) {
                    return median(a1[x1], a2[ym], a2[ym-1], a2[ym+1]);
                } else {
                    return median(a1[x1], a2[ym], a2[ym-1]);
                }
            }
            if (  s1 == 2 ) {
                if ( s2 == 2 ) return median(a1[x1], a1[x2], a2[y1], a2[y2]);
                int ym = y1 + s2/2;
                if ( s2 % 2 != 0 ) {
                    return median(a2[ym], Math.max(a1[x1], a2[ym-1]), Math.min(a1[x2], a2[ym+1]));
                } else {
                    return median(a2[ym], a2[ym-1], Math.max(a1[x1], a2[ym-2]), Math.min(a1[x2], a2[ym+1]));
                }
            }
            double m1 = findMedian(x1, x2, a1);
            double m2 = findMedian(y1, y2, a2);
            if ( m1 == m2 ) return m1;
            int d1 =  ( s1 % 2 == 0 ) ? s1/2 - 1 : s1/2;
            int d2 =  ( s2 % 2 == 0 ) ? s2/2 - 1 : s2/2;
            if ( m1 < m2 ) {
                return find( x1 + d1, x2, y1, y2-d1);
            } else {
                return find( x1, x2 - d1, y1 + d1, y2);
            }
        }

        double findMedian(int i, int j, int[] a) {
            int s = j - i + 1;
            int d = i + s / 2;
            return (s % 2 == 0) ? (a[d - 1] + a[d]) / 2d : a[d];
        }

        double median(int ... x) {
            Arrays.sort(x);
            int l = x.length;
            int d = l/2;
            return ( l % 2 == 0 ) ?  (x[d-1] + x[d]) / 2d :  x[d];
        }
    }


    public static void main(String[] args) {

        System.out.println(
                new BruteForceFinder(new int[]{-3, -2, 0,  8, 9, 99}, new int[]{3, 4, 5, 6, 7, 10, 12, 14,17, 22}).find());
        System.out.println(
                new OptFinder(new int[]{-3, -2 , 0, 8, 9, 99}, new int[]{3, 4, 5, 6, 7, 10, 12, 14,17, 22}).find());
    }

}
