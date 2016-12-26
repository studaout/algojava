package studaout.matrix;

import studaout.Util;

/**
 * http://www.geeksforgeeks.org/find-the-largest-rectangle-of-1s-with-swapping-of-columns-allowed/
 * Given a matrix with 0 and 1’s, find the largest rectangle of all 1’s in the matrix.
 * The rectangle can be formed by swapping any pair of columns of given matrix.
 */
public class LargestRectangleOf1s {

    public static int find(int [][] m) {
        int c = m[0].length;
        int r = m.length;
        int [][] aux = new int[r][c];
        for ( int i = 0; i<c; ++i ) {
            aux[0][i] = m[0][i]; //copy first row
            for ( int j = 1; j<r;++j ) {
                aux[j][i] = ( m[j][i] > 0 ) ? m[j][i] + aux[j-1][i] : 0;
            }
        }
        for ( int i = 0; i<r; ++i ) {
            int [] count = new int[r+1];
            for ( int j=0;j<c; ++j) count[aux[i][j]]++;
            int cur = 0;
            for ( int j=r;j>=0;--j) {
                if ( count[j] > 0 ) {
                    for ( int k = 0; k < count[j]; ++k) {
                        aux[i][cur] = j;
                        cur++;
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < r; ++i ) {
            for ( int j = 0; j < c; ++j ) {
                int cur = aux[i][j]*(j+1);
                if ( cur > max ) max = cur;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int [][] m1 = {
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1}
        };
        System.out.println(find(m1));
        int [][] m2 = {
                {0, 1, 0, 1, 0},
                {0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0}
        };
        System.out.println(find(m2));
    }
}
