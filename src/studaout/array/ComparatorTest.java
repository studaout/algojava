package studaout.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ComparatorTest {

    public static void main(String[] args) {
        Integer arr[] = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> l = Arrays.asList(arr);
        l.sort((Integer a, Integer b) -> (a > b) ? 1 : (a.equals(b) ? 0 : -1));
        System.out.println("natural: " + l);
        l = Arrays.asList(arr);
        l.sort((Integer a, Integer b) -> (a < b) ? 1 : (a.equals(b) ? 0 : -1));
        System.out.println("reverse: " + l);
        l = Arrays.asList(arr);
        l.sort((Integer a, Integer b) -> 1);
        System.out.println("reverse: " + l);
        l.sort((Integer a, Integer b) -> -1);
        System.out.println("reverse: " + l);
    }
}
