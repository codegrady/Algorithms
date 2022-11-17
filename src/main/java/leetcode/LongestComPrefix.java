package leetcode;

/**
 * 14
 */
public class LongestComPrefix {
    public static void main(String[] args) {
        String[] strs = {"reflower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        //找最短字符串
        String s = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (s.length() > strs[i].length()) {
                s = strs[i];
            }
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            boolean f = true;
            for (int i1 = 0; i1 < strs.length; i1++) {
                if(strs[i1].charAt(i) != s.charAt(i)){
                    f = false;
                    break;
                }
            }
            System.out.println(f);
            if(f){
                sb.append(s.charAt(i));
            }else {
                break;
            }
        }

        return sb.toString();
    }
}
