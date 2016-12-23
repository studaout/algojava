package studaout;

/**
 * Created by timout on 2/10/15.
 */
public class IntPair {
    public final Integer first;
    public final Integer second;

    public IntPair(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return first + " : " + second;
    }
}
