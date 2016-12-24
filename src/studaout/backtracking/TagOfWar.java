package studaout.backtracking;

import studaout.Util;

public class TagOfWar {

    static class TSet {
        final int size;
        int i = 0;
        int sum = 0;
        final int [] arr;

        public TSet(int size) {
            this.size = size;
            arr = new int[size];
        }

        public void push(int val ) {
            arr[i] = val;
            sum += val;
            ++i;
        }

        public void pop() { --i; sum-=arr[i]; arr[i] = 0; }

        public boolean isFool() { return i == size; }

        public boolean notFool() { return i < size; }

        public TSet copy() {
            TSet n = new TSet(size);
            for ( int j = 0; j < size; ++j ) {
                n.push(arr[j]);
            }
            return n;
        }
    }

    static class Pair {
        final TSet r;
        final TSet l;
        final int diff;

        public Pair(TSet l, TSet r, int diff) {
            this.r = r;
            this.l = l;
            this.diff = diff;
        }
    }

    public static Pair find(int [] arr) {
        int l = arr.length/2;
        int r = arr.length-l;
        return find(new Pair(null, null, Integer.MAX_VALUE), 0, arr, new TSet(l), new TSet(r));
    }

    public static Pair find(Pair cur, int start, int [] arr, TSet l, TSet r) {
        if ( start >= arr.length ) {
            int n = Math.abs((l.sum - r.sum));
            //System.out.println("curr diff: " + n);
            return (n > cur.diff) ? cur : new Pair(l.copy(), r.copy(), n);
        }
        int val = arr[start];
        if ( l.notFool() ) {
            l.push(val);
            Pair res = find(cur, start+1, arr, l, r);
            l.pop();
            if ( r.notFool() ) {
                r.push(val);
                res = find(res, start+1, arr, l, r);
                r.pop();
                return res;
            } else {
                return res;
            }
        } else {
            r.push(val);
            Pair res = find(cur, start+1, arr, l, r);
            r.pop();
            return res;
        }
    }

    public static void main(String[] args) {
        int arr[] = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
        Pair res = find(arr);
        Util.print(res.l.arr);
        Util.print(res.r.arr);
        System.out.println("diff: " + res.diff);
    }
}
