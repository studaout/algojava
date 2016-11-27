package studaout.math;

public class PalindromeNumber {

    public static boolean isPalindromeReverse(int i) {
        return i >= 0 && ReverseInteger.reverse(i) == i; //overflow does not work
    }

    public static boolean isPalindrome(int i) {
        if ( i < 0 ) return false;
        int size = 1;
        while ( i/(size*10) > 0 ) size *= 10;
        while ( i > 0 ) {
            int r = i % 10;
            int l = i / size;
            if ( l != r ) return false;
            i %= size;
            i /= 10;
            size /= 100;
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(isPalindromeReverse(12345));
        System.out.println(isPalindromeReverse(5678765));
        System.out.println(isPalindrome(12345));
        System.out.println(isPalindrome(11811));
    }
}
