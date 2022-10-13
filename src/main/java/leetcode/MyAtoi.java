package leetcode;

public class MyAtoi {

    public static void main(String[] args) {
        String s = "+-12";
        System.out.println(myAtoi(s));

    }

    public static int myAtoi(String s){
        long ret = 0;
        int sign = 1;
        boolean hasNum = false;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(Character.isSpaceChar(cur)){
                continue;
            }else if((cur == '-'|| cur == '+') && !hasNum){
                if(cur == '-') {
                    sign = -1;
                }
                hasNum = true;
            }else if(Character.isDigit(cur)){
                ret = ret*10+cur-'0';
            }else {
                break;
            }
        }
        ret *= sign;

        return ret>Integer.MAX_VALUE?Integer.MAX_VALUE:ret<Integer.MIN_VALUE?Integer.MIN_VALUE:(int)ret;
    }
}
