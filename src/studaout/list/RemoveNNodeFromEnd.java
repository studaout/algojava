package studaout.list;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Given a linked list, remove the nth node from the end of list and return its head.
 *  For example, Given linked list: 1->2->3->4->5, and n = 2.
 *  After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class RemoveNNodeFromEnd {

    public static SingleNode<Integer> remove(int n, SingleNode<Integer> list) {
        SingleNode<Integer> root = list;
        if ( list == null ) return null;
        SingleNode<Integer> i1 = list;
        SingleNode<Integer> i2 = list;
        for ( int i = 0; i < n; ++i ) {
            i2 = i2.getNext();
            if ( i2 == null ) return root;
        }
        if ( i2.getNext() == null ) {
            return root.getNext();
        }
        i2 = i2.getNext();
        while ( i2.getNext() != null ) {
            i2 = i2.getNext();
            i1 = i1.getNext();
        }
        i1.setNext(i1.getNext().getNext());
        return root;
    }

    public static void main(String[] args) {
        SingleNode.println(remove(2, SingleNode.create(1,2)));
        SingleNode.println(remove(2, SingleNode.create(1,2,3)));
        SingleNode.println(remove(2, SingleNode.create(1,2,3,4,5,6,7)));
    }
}
