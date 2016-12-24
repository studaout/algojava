package studaout.backtracking;

import studaout.Util;

import java.util.Optional;

/**
 * http://www.geeksforgeeks.org/backttracking-set-5-m-coloring-problem/
 */
public class ColoringProblem {

    public static Optional<int []> find(int [][] arr, int m) {
        int [] cmap = new int[arr.length];
        return (find(0, arr, cmap, m)) ? Optional.of(cmap) : Optional.<int[]>empty();
    }

    public static boolean find(int cur, int [][] arr, int [] cmap, int m) {
        int size = arr.length;
        if ( cur == size ) return true;
        for (int c=1; c<=m; ++c) {
            if ( isValid(c, cur, arr, cmap) ) {
                cmap[cur] = c;
                if ( find(cur + 1, arr, cmap, m) ) return true;
                cmap[cur] = 0;
            }
        }
        return false;
    }

    static boolean isValid(int c, int p, int [][] arr, int [] cmap) {
        int size = arr.length;
        for ( int i = 0; i<size; ++i ) {
            if ( i == p ) continue;
            if ( arr[p][i] == 1 &&  cmap[i] == c ) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        int v = 4;
        int graph[][] = {
            {0, 1, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {1, 0, 1, 0},
        };
        int m = 3;
        Optional<int []> res = find(graph,m);
        if ( res.isPresent() ) {
            Util.print(res.get());
        } else {
            System.out.println("not possible");
        }
    }
}
