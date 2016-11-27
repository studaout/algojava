package studaout.math;

public class ReverseInteger {

    public static int reverse(int i) { //overflow?
        int res = 0;
        boolean sign = i < 0;
        if ( sign ) i *= -1;
        while ( i > 0 ) {
            res = res*10 + i%10;
            i /=10;
        }
        return ( sign ) ? -res : res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-12345));
    }
}
