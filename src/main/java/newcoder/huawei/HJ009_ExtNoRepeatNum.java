package newcoder.huawei;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 *  提取不重复的整数
 * 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是 0 。
 * 输入：9876673
 * 输出：37689
 */
public class HJ009_ExtNoRepeatNum {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for(int i = str.length()-1;i>=0;i--){
            set.add(str.charAt(i));
        }
        set.forEach(System.out::print);
    }
}
