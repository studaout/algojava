package studaout.backtracking;

import studaout.Util;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * http://www.geeksforgeeks.org/backtracking-set-1-the-knights-tour-problem/
 * The knight is placed on the first block of an empty board and, moving according
 * to the rules of chess, must visit each square exactly once.
 */
public class KnightTour {

    public static int N = 8;

    static class Step {
        public final int x, y;
        public Step(int x, int y) {   this.x = x;  this.y = y;  }
    }

    static class Position {
        public final int x, y;
        public Position(int x, int y) {   this.x = x;  this.y = y;  }
        public Position move(Step s) { return new Position(x + s.x, y + s.y); }
    }

    static Step [] moves = {
            new Step(2,1),
            new Step(1,2),
            new Step(-1,2),
            new Step(-2,1),
            new Step(-2,-1),
            new Step(-1,-2),
            new Step(1,-2),
            new Step(2,-1)
    };

    public static Optional<int [][]> find() {
        int [][] arr = new int[N][N];
        IntStream.range(0, N).forEach(i-> {
            int [] r = new int[N];
            Arrays.fill(r, -1);
            arr[i] = r;
        });
        arr[0][0] = 0;
        boolean res = find(1, new Position(0,0), arr);
        return ( res ) ? Optional.of(arr) : Optional.empty();
    }

    public static boolean find(int step, Position curPos, int [][] arr) {
        if ( step == N*N ) {
            return true;
        }
        for ( Step s : moves ) {
            Position next = curPos.move(s);
            if ( isValid(next, arr) ) {
                arr[next.x][next.y] = step;
                if ( find(step+1, next, arr) ) {
                    return true;
                } else {
                    arr[next.x][next.y] = -1;
                }
            }
        }
        return false;
    }

    static boolean isValid(Position p, int [][] arr) {
        return ( p.x >=0 && p.y >= 0 && p.x < N && p.y < N && arr[p.x][p.y] == -1);
    }



    public static void main(String[] args) {
        Optional<int [][]> res = find();
        res.ifPresent(Util::print);
    }
}
