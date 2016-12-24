package studaout.backtracking;

import studaout.Util;

import java.util.LinkedList;
import java.util.Optional;

/**
 * http://www.geeksforgeeks.org/backtracking-set-7-suduku/
 */
public class Sudoku {

    static class Cell {
        public final int x;
        public final int y;
        public final int sx;
        public final int sy;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
            this.sx = 3*(x/3);
            this.sy = 3*(y/3);
        }
    }

    public static Optional<int [][] > find(int [][] arr) {
        LinkedList<Cell> list = new LinkedList<>();
        for ( int i=0; i<9; ++i) {
            for ( int j=0; j<9; ++j) {
                if ( arr[i][j] > 0 ) continue;
                Cell c = new Cell(i,j);
                list.add(c);
            }
        }
        if ( list.size() == 0 ) return Optional.of(arr);
        Cell [] cells = list.toArray(new Cell [list.size()]);



        return find(0, cells, arr) ? Optional.of(arr) : Optional.<int[][]>empty();
    }

    public static boolean find(int cur, Cell[] cells, int [][] arr) {
        if ( cur >= cells.length ) return true;
        Cell cell = cells[cur];
        for ( int v = 1; v < 10; ++v ) {
            if ( isValid(v, cell, arr) ) {
                arr[cell.x][cell.y] = v;
                if ( find(cur+1, cells, arr) ) return true;
                arr[cell.x][cell.y] = 0;
            }
        }
        return false;
    }

    static boolean isValid(int v, Cell cell, int [][] arr) {
        for ( int i = 0; i < 9; ++i ) {
            if ( arr[cell.x][i] == v || arr[i][cell.y] == v ) return false;
        }
        for ( int i=0; i<3; ++i) {
            for ( int j=0; j<3; ++j) {
                if ( arr[cell.sx+i][cell.sy+j] == v ) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        Optional<int [][]> res = find(arr);
        if ( res.isPresent() ) {
            Util.print(res.get());
        } else {
            System.out.println("not found");
        }
    }
}
