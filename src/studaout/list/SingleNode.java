package studaout.list;

import java.util.Collections;
import java.util.List;

public class SingleNode<T> {
    
    public final T key;

    private SingleNode<T> next;

    public static <T> SingleNode<T> create(List<T> l) {
        SingleNode<T> root = null;
        Collections.reverse(l);
        for( T t : l) {
            root = new SingleNode<>(t, root);
        }
        return root;
    }

    public static <T> SingleNode<T> create(T... a) {
        SingleNode<T> root = null;
        for ( int i = a.length-1; i >=0; --i) {
            root = new SingleNode<>(a[i], root);
        }
        return root;
    }

    public SingleNode(T key) {
        this.key = key;
    }

    public SingleNode(T key, SingleNode<T> next) {
        this.key = key;
        this.next = next;
    }

    public T getKey() {
        return key;
    }

    public SingleNode<T> getNext() {
        return next;
    }

    public boolean hasNext() {
        return next != null;
    }

    public boolean hasNotNext() {
        return next == null;
    }

    public SingleNode<T> toLast() {
        SingleNode<T> c = this;
        while ( c.next != null ) c = c.next;
        return c;
    }

    public int size() {
        int i = 1;
        SingleNode<T> c = this;
        while ( c.next != null ) {
            c = c.next;
            ++i;
        }
        return i;
    }

    public void setNext(SingleNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return key.toString();
    }

    public static <T> void println(SingleNode<T> r) {
        while (r != null ) {
            System.out.print(r.key + " ");
            r = r.getNext();
        }
        System.out.println();
    }
}
