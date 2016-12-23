package studaout.array;

public class DuplicatesInArray {

    public static void print(int [] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i ) {
            int v = arr[i];
            int ni = Math.abs(v);
            if ( arr[ni] < 0 ) {
                System.out.print(ni + " ");
            } else {
                arr[ni] = - arr[ni];
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1, 3, 6, 6};
        print(arr);
    }
}
