package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。

 示例 1：
 输入: s1 = "abc", s2 = "bca"
 输出: true

 示例 2：
 输入: s1 = "abc", s2 = "bad"
 输出: false

 说明：
 0 <= len(s1) <= 100
 0 <= len(s2) <= 100

 Related Topics 哈希表 字符串 排序 👍 132 👎 0
 */
public class CheckPermutation {

    public static void main(String[] args) {
        String s1 = "bsdfpjkac",s2="bsdfhjkac";
        System.out.println(solutionByArray(s1, s2));
    }

    public static boolean solutionByHash(String s1,String s2){
        //特殊情况
        if(s1.length() != s2.length()){
            return false;
        }
        if(s1.length() == 1){
            return s1.equals(s1);
        }
        Map<Character,Integer> map = new HashMap<>();
        int left = s1.length();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if(!map.containsKey(c)){
                return false;
            }else {
                int times = map.get(c) - 1;
                if(times<0){
                    return false;
                }
                left--;
                map.put(c,times);
            }
        }

        return left==0;
    }

    public static boolean solutionByArray(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        if(s1.length() == 1){
            return s1.equals(s1);
        }
        int[] array = new int[256];
        int left = s1.length();
        for (int i = 0; i < left; i++) {
            array[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if(array[c]>0){
                array[c]--;
                left --;
            }else {
                return false;
            }
        }
        return left == 0;
    }
}
