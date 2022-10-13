package leetcode;

public class StringZConvert {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 3));

    }

    public static String convert(String s,int numRows) {
        if(numRows ==1){
            return s;
        }
        int N = s.length();
        int length = 0;
        int x = 0;
        //计算列数
        while (x < N) {
            if (length % (numRows - 1) == 0) {
                x += numRows;
            } else {
                x += 1;
            }
            length++;
        }
        char[][] matrix = new char[numRows][length];
        int col = 0, row = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println("row = "+row+" col = "+col + " c = " + c);
            matrix[row][col] = c;
            if (col % (numRows-1) == 0 && row<numRows-1) {
                row++;
            } else {
                row--;
                col++;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < length; j++) {
                if(matrix[i][j] == Character.MIN_VALUE){
                    continue;
                }
                sb.append(matrix[i][j]);
            }
        }
        return sb.toString();
    }
}
