package studaout.backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *  Given 4 pairs of socks one of each yellow,blue,black,green.
 *  You have arrange them in such a way that
 *  there are
 *  4 socks in between yellow socks ,
 *  3 in between the blue socks,
 *  2 in between the black and
 *  1 in between the green socks.
 */
public class ColorSocks {

    static Set<String> set = new HashSet<>();

    static enum Color {
        Y('y',4, "yellow"), B('b',3, "blue"), K('k',2, "black"), G('g',1, "green");
        final int l;
        final char c;
        final String name;
        private Color(char c, int l, String name) { this.c = c; this.l = l; this.name = name;}

        public static Color get(char chr) {
            for( Color c : values() ) {
                if ( c.c == chr ) return c;
            }
            throw new IllegalArgumentException("unknown character " + chr);
        }

        @Override
        public String toString() { return name; }
    }

    public static void find() {
        StringBuilder b = new StringBuilder();
        for ( Color c : Color.values() ) {
            b.append(c.c).append(c.c);
        }
        char [] arr = b.toString().toCharArray();
        find(0, arr);
    }

    public static void find(int start, char [] arr) {
        int n = arr.length;
        if ( start == n-1) {
            if ( isValid(arr) ) set.add(new String(arr));
        } else {
            find(start + 1, arr);
            for (int i = start + 1; i < n; ++i) {
                swap(start, i, arr);
                find(start + 1, arr);
                swap(start, i, arr);
            }
        }
    }

    static void swap(int i, int j, char [] arr) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    public static boolean isValid(char [] arr){
        String s = new String(arr);
        int l = s.length()-1;
        for ( Color c : Color.values() ) {
            int i = s.indexOf(c.c);
            int n = i + c.l + 1;
            if ( (i + c.l + 1) > l ) return false;
            if ( s.charAt(n) != c.c ) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        find();
        set.forEach(s -> {
            System.out.print(s + " - ");
            for ( char c : s.toCharArray()) {
                System.out.print(Color.get(c) + " ");
            }
            System.out.println();
        });
    }
}
