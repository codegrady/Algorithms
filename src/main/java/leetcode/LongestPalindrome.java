package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 * Related Topics
 * 字符串
 * 动态规划
 *
 * 1 暴力破解 O（N^3）
 * 2 中心扩散　O（N＾２）
 * 3 动态规划 O（N＾２）
 * 4 Mancacher 算法
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        String sub = "";
        for(int i =0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                int l = i-map.get(s.charAt(i));
                if(l>max){
                    max = l;
                    sub = s.substring(map.get(s.charAt(i)),i+1);
                }
                map.put(s.charAt(i),i);
            }else {
                map.put(s.charAt(i),i);
            }
        }
        return sub.length()!=0?sub:s.substring(0,1);
    }
}
