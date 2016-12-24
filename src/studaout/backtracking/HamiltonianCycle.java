package studaout.backtracking;

import studaout.Util;

import java.util.Arrays;
import java.util.Optional;

/**
 * http://www.geeksforgeeks.org/backtracking-set-7-hamiltonian-cycle/
 */
public class HamiltonianCycle {

    public static Optional<int []> find(int [][] arr) {
        int size = arr.length;
        int [] path = new int[size+1];
        int [][] pathMap = new int[size][size]; //pathMap can be substituted by search over path or by set
        Arrays.fill(path, -1);
        path[0] = 0;
        return (find(0, 1, path, pathMap, arr)) ? Optional.of(path): Optional.<int[]>empty();
    }

    public static boolean find(int cur, int pos, int [] path, int [][] pathMap, int [][] arr) {
        int size = arr.length;
        if ( pos > size ) {
            return path[size] == 0;
        }
        for ( int i=0; i<size; ++i ) {
            if ( i == cur ) continue;
            if ( isValid(cur, i, pathMap, arr) ) {
                pathMap[cur][i] = 1;
                pathMap[i][cur] = 1;
                path[pos] = i;
                boolean res = find(i, pos+1, path, pathMap, arr);
                if ( res ) return true;
                path[pos] = -1;
                pathMap[cur][i] = 0;
                pathMap[i][cur] = 0;
            }
        }
        return false;
    }

    static boolean isValid(int cur, int pos, int [][] pathMap, int [][] arr) {
        return ( arr[cur][pos] == 1 && pathMap[cur][pos] == 0  && pathMap[pos][cur] == 0);
    }

    public static void main(String[] args) {
        int [][] graph1 = {
            {0, 1, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 1},
            {0, 1, 1, 1, 0},
        };
        find(graph1).ifPresent(Util::print);

        int [][] graph2 = {
            {0, 1, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 0},
            {0, 1, 1, 0, 0},
        };
        find(graph2).ifPresent(Util::print);

        int [][] graph3 = {
                {0, 1, 0},
                {1, 0, 1},
                {1, 1, 0},
        };
        find(graph3).ifPresent(Util::print);
    }
}
