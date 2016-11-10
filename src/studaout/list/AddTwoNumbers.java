package studaout.list;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and
 * each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */

public class AddTwoNumbers {

    public static SingleNode<Integer> calculate(SingleNode<Integer> l1, SingleNode<Integer> l2) {
        SingleNode<Integer> cur = null;
        SingleNode<Integer> start = null;
        if ( l1 == null && l2 == null ) return null;
        if ( l1 == null ) return l2;
        if ( l2 == null ) return l1;
        int a  = 0;
        while ( l1 != null || l2 != null ) {
            int k = a;
            if ( l1 != null ) {
                k += l1.getKey();
                l1 = l1.getNext();
            }
            if ( l2 != null ) {
                k += l2.getKey();
                l2 = l2.getNext();
            }
            if ( k > 9 ) {
                k = k - 10;
                a = 1;
            } else {
                a = 0;
            }
            SingleNode<Integer> n = new SingleNode<>(k, null);
            if ( cur != null ) {
                cur.setNext(n);
            } else {
                start = n;
            }
            cur = n;
        }
        if ( a > 0 ) {
            cur.setNext(new SingleNode<>(a, null));
        }
        return start;
    }

    public static void main(String[] args) {
        SingleNode<Integer> l1 = SingleNode.create(Arrays.asList(2,4,3));
        SingleNode<Integer> l2 = SingleNode.create(Arrays.asList(9,6,7, 9));
        SingleNode<Integer> res = calculate(l1,l2);
        SingleNode.println(res);
    }
}
