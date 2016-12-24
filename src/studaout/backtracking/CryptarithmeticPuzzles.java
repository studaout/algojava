package studaout.backtracking;

import java.util.*;

/**
 * http://www.geeksforgeeks.org/backtracking-set-8-solving-cryptarithmetic-puzzles/
 */
public class CryptarithmeticPuzzles {

    static class Puzzle {
        final String part1;
        final String part2;
        final String ans;
        final Character [] arr;

        private List<Map<Character, Integer>> solutions = new LinkedList<>();

        public Puzzle(String part1, String part2, String ans) {
            this.part1 = part1;
            this.part2 = part2;
            this.ans = ans;
            Set<Character> characters = new HashSet<>();
            part1.chars().forEach(c -> characters.add((char)c));
            part2.chars().forEach(c -> characters.add((char)c));
            ans.chars().forEach(c -> characters.add((char)c));
            arr = characters.toArray(new Character[characters.size()]);
        }

        public int size() { return arr.length; }

        public boolean isSolved(HashMap<Character, Integer> map) {
            int p1 = part1.chars().map(c-> map.get((char)c)).reduce(0, (d1, d2) -> d1*10 + d2);
            int p2 = part2.chars().map(c-> map.get((char)c)).reduce(0, (d1, d2) -> d1*10 + d2);
            int a = ans.chars().map(c-> map.get((char)c)).reduce(0, (d1, d2) -> d1*10 + d2);
            boolean res = ( a == p1+p2);
            if ( res ) {
                solutions.add((Map<Character, Integer>)map.clone());
//                int pt = part2.chars().map(c-> map.get((char)c)).reduce(0, (d1, d2) -> {
//                    int r = d1*10 + d2;
//                    return r;
//                });
            }
            return res;
        }

        public void print() {
            String sf = "%" + ans.length() + "s%n";
            String af = "%" + ans.length() + "d%n";
            System.out.println("Puzzle: ");
            System.out.printf(sf, part1);
            System.out.printf(sf,"+");
            System.out.printf(sf,part2);
            System.out.printf("%s%n","______");
            System.out.printf(sf,ans);
            System.out.println("Solutions: ");
            for ( Map<Character, Integer> s : solutions ) {
                int p1 = part1.chars().map(c -> s.get((char) c)).reduce(0, (d1, d2) -> d1 * 10 + d2);
                int p2 = part2.chars().map(c -> s.get((char) c)).reduce(0, (d1, d2) -> d1 * 10 + d2);
                int a = ans.chars().map(c -> s.get((char) c)).reduce(0, (d1, d2) -> d1 * 10 + d2);
                System.out.printf(af, p1);
                System.out.printf(sf, "+");
                System.out.printf(af, p2);
                System.out.printf("%s%n", "______");
                System.out.printf(af, a);
                System.out.println("---------");
            }
        }


    }

    public static Puzzle find(Puzzle p){
        find(0, new HashMap<>(), p);
        return p;
    }

    public static void find(int cur, HashMap<Character, Integer> map, Puzzle p) {
        if ( cur >= p.size() ) {
            p.isSolved(map);
            return;
        }
        for ( int i = 0; i < 10; ++i ) {
            if ( ! map.values().contains(i) ) {
                map.put(p.arr[cur], i);
                find(cur+1, map, p);
                map.remove(p.arr[cur]);
            }
        }
    }

    public static void main(String[] args) {
        Puzzle p = new Puzzle("send", "more", "money");
        Puzzle res = find(p);
        res.print();
    }
}
