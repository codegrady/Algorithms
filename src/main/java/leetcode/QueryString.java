package leetcode;

public class QueryString {

    public static void main(String[] args) {
        String s = "0110";
    }
    public static boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            if(!s.contains(Integer.toBinaryString(i))){
                return false;
            }
        }
        return true;
    }
}
