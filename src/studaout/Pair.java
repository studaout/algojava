package studaout;

public class Pair<A,B> {
    public final A first;
    public final B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public static <A,B> Pair<A,B> create( A first, B second) {
        return new Pair<>(first, second);
    }

    @Override
    public String toString() {
        return "Pair{first=" + first + ", second=" + second + '}';
    }
}
