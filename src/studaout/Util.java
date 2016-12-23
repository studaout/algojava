package studaout;

import java.util.Arrays;
import java.util.List;

/**
 * Created by timout on 1/28/15.
 */
public class Util {

    public static long min(long... l) {
        return Arrays.stream(l).min().orElseThrow( () -> new IllegalArgumentException("no min"));
    }
    public static int min(int... l) {
        return Arrays.stream(l).min().orElseThrow( () -> new IllegalArgumentException("no min"));
    }

    public static int max(int... l) {
        return Arrays.stream(l).max().orElseThrow( () -> new IllegalArgumentException("no max"));
    }
    public static long max(long... l) {
        return Arrays.stream(l).max().orElseThrow( () -> new IllegalArgumentException("no max"));
    }

    public static void sleep(long t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            //
        }
    }

    public static <T> void print(List<T> list) {
        StringBuilder b = new StringBuilder();
        list.forEach(i -> b.append(i).append(" "));
        System.out.println(b.toString());
    }


    public static void print(Integer [] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void print(int [] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void print(int [] [] arr) {
        for ( int [] r : arr ) {
            for ( int i : r ) {
                System.out.printf("%3d ", i);
            }
            System.out.println();
        }
    }
}
