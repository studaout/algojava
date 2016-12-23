package studaout.array;

import studaout.Util;

public class FindElementAppearsOnceInSortedArray {

    public static int findNaive(int [] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i +=2) {
            if ( arr[i] != arr[i-1] ) return arr[i-1];
        }
        throw new IllegalStateException("no appears once element");
    }

    public static int findBinary(int [] arr) {
        int l = arr.length-1;
        int s = 0;
        while( s < l) {
            int i = s + (l-s)/2;
            if ( arr[i] == arr[i-1] ) {
                s = i;
            } else if ( arr[i] == arr[i+1] ) {
                l = i;
            } else {
                return arr[i];
            }

        }
        throw new IllegalStateException("no appears once element");
    }


    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6, 7, 7, 8, 8};
        Util.print(arr);
        System.out.println("---------------");
        System.out.println(findNaive(arr));
        System.out.println(findBinary(arr));

    }
}
