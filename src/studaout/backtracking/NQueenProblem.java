package studaout.backtracking;

import studaout.Util;

import java.util.Optional;
import java.util.stream.IntStream;

public class NQueenProblem {

    public static Optional<int[][]> find(int size) {
        int [][] arr = new int[size][size];
        boolean res = find(0, arr, size);
        return ( res ) ? Optional.of(arr) : Optional.empty();
    }

    public static boolean find(int col, int [][] arr, int size) {
        if ( col == size ) return true;
        for ( int l = 0; l < size; ++l ) {
            if ( arr[l][col] == 0 ) {
                fill(-col-1, l, col, arr, size, false);
                arr[l][col] = col+1;
                boolean res = find(col+1, arr, size);
                if ( res ) {
                    return true;
                } else {
                    fill(-col-1, l, col, arr, size, true);
                    arr[l][col] = 0;
                }
            }
        }
        return false;
    }

    static void fill(int val, int i, int j, int [][] arr, int size, boolean reset) {
        IntStream.range(0, size).forEach( c-> {
            if ( reset ) {
                if ( arr[i][c] == val ) arr[i][c] = 0;
                if ( arr[c][j] == val ) arr[c][j] = 0;
            } else {
                if ( arr[i][c] == 0 ) arr[i][c] = val;
                if ( arr[c][j] == 0 ) arr[c][j] = val;
            }
        });
        int x = 0;
        int y = 0;
        if (  i > j ) {
            x = i - j;
        } else {
            y = j - i;
        }
        while (x < size && y < size) {
            if ( reset ) {
                if ( arr[x][y] == val ) arr[x][y] = 0;
            } else {
                if ( arr[x][y] == 0 ) arr[x][y] = val;
            }
            x++;
            y++;
        }
        int s = i + j;
        if ( s >= size) {
            x = size-1;
            y = s - size+1;
        } else {
            x = s;
            y = 0;
        }
        while ( x >= 0 && y < size) {
            if ( reset ) {
                if ( arr[x][y] == val ) arr[x][y] = 0;
            } else {
                if ( arr[x][y] == 0 ) arr[x][y] = val;
            }
            x--;
            y++;
        }

    }

    public static void main(String[] args) {
        Optional<int [][]> res = find(8);
        res.ifPresent(Util::print);
    }
}
