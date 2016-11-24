package studaout.string;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * P     I     N    PINALSIGYAHRPI
 * A   L S   I G
 * Y A   H R
 * P     I
 * And then read line by line: "PAHNAPLSIIGYIR"
 */
public class ZigZagConversion {

    public static String convert(String str, int rows) {
        if ( str == null || str.isEmpty() || rows < 2 ) return str;
        int l = str.length();
        char [] arr = new char[l];
        int cycle = 2*rows-2; //num of items in column+diagonal;
        int i = 0;
        int row = 0;
        int col = 0;
        while ( i < l) {
            int j = row;
            if ( row == 0 || row == rows-1 ) { //first or last row
                j += col * cycle;
            } else {
                j += (col/2) * cycle + (( col % 2 == 0 ) ? 0 : (cycle-2*row)); //column or diagonal
            }
            col +=1;
            if ( j >= l ){ //to next row
                row += 1;
                j = row;
                col = 1;
            }
            arr[i] = str.charAt(j);
            i += 1;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        String res = convert("PAYPALISHIRING",3);
        System.out.println(str + "(3)" + (( res.equals("PAHNAPLSIIGYIR") ) ? "==" : "!=" ) + res);
        res = convert("PAYPALISHIRING",4);
        System.out.println(str + "(4)" + (( res.equals("PINALSIGYAHRPI") ) ? "==" : "!=" ) + res);
        res = convert("PAYPALISHIRING",5);
        System.out.println(str + "(5)" + (( res.equals("PHASIYIRPLIGAN") ) ? "==" : "!=" ) + res);
    }
}

