package studaout.array;

import java.util.Arrays;
import java.util.LinkedList;

public class NextGreaterElement {

    public static void print(int [] arr) {
        LinkedList<Integer> stack = new LinkedList<>();
        Arrays.stream(arr).forEach(i -> {
            if ( stack.size() > 0 ) {
                boolean found = true;
                do {
                    int cs = stack.pop();
                    if ( i > cs ) {
                        System.out.println( cs  + " -> " + i);
                    } else {
                        stack.push(cs);
                        found = false;
                    }
                } while (found && stack.size() > 0);
            }
            stack.push(i);
        });
        stack.forEach(i-> System.out.println(i + " -> -1" ));
    }

    public static void main(String[] args) {
        int arr[]= {11, 13, 21, 3};
        print(arr);
        System.out.println("----------");
        print(new int [] {13, 7, 6, 12});
    }
}
