package studaout.bit;

public class BitUtil {

    public static int countBits(long i) {
        // HD, Figure 5-14
        i = i - ((i >>> 1) & 0x5555555555555555L);
        i = (i & 0x3333333333333333L) + ((i >>> 2) & 0x3333333333333333L);
        i = (i + (i >>> 4)) & 0x0f0f0f0f0f0f0f0fL;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        i = i + (i >>> 32);
        return (int)i & 0x7f;
    }

    public static int countBits(int i) {
        i = i - (( i >> 1 ) & 0x55555555);
        i = ( i & 0x3333333 ) + ( (i >>2) & 0x33333333 );
        return  ((( i + ( i >>4 )) & 0x0f0f0f0f) * 0x01010101) >> 24;
    }

    public static void main(String[] args) {
        int i = 6964798;
        long l = 1234567890123456789L;
        System.out.println(countBits(i) + " : " + Integer.bitCount(i));
        System.out.println(countBits(l) + " : " + Long.bitCount(l));
    }

}
