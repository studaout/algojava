package studaout.list;

/**
 * Created by timout on 12/4/16.
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
