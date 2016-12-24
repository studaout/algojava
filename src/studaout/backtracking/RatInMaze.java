package studaout.backtracking;

import studaout.Util;

/**
 * http://www.geeksforgeeks.org/backttracking-set-2-rat-in-a-maze/
 */
public class RatInMaze {

    static final int N = 5;

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
            new Step(0,1),
            new Step(1,0)
    };


    public static boolean find(int [][] maze) {
        maze[0][0] = 1;
        return find(2, new Position(0,0), maze);
    }

    static boolean find(int step, Position position, int [][] maze) {
        if ( position.x == N-1 && position.y == N-1 ) {
            return true;
        }
        for ( Step s : moves ) {
            Position next = position.move(s);
            if ( isValid(next, maze) ) {
                maze[next.x][next.y] = step;
                boolean res = find(step+1, next, maze);
                if ( res ) {
                    return true;
                } else {
                    maze[next.x][next.y] = 0;
                }
            }
        }
        return false;
    }

    static boolean isValid(Position p, int [][] arr) {
        return ( p.x >=0 && p.y >= 0 && p.x < N && p.y < N && arr[p.x][p.y] == 0);
    }


    public static void main(String[] args) {
        int [][] maze =  {
                {0, -1, -1, -1, -1},
                {0,  0, -1,  0, -1},
                {-1, 0,  0, -1, -1},
                {0,  0,  0, -1,  0},
                {0,  0,  0,  0,  0}
        };
        if ( find(maze) ) {
            Util.print(maze);
        } else {
            System.out.println("The maze has no exit");
        }
    }
}
