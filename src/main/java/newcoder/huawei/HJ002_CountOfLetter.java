package newcoder.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 描述
    写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）

    数据范围： 1 \le n \le 1000 \1≤n≤1000 
    输入描述：
    第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字符。

    输出描述：
    输出输入字符串中含有该字符的个数。（不区分大小写字母）

    示例1
        输入：ABCabc
              A
    
        输出：2
 */
public class HJ002_CountOfLetter{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toLowerCase();
        char key = br.readLine().toLowerCase().charAt(0);
        br.close();

        Map<Character,Integer> map = new HashMap();
        for(int i = 0;i<str.length();i++){
            char x = str.charAt(i);
            if(map.containsKey(x)){
                map.put(x, map.get(x)+1);
            }else{
                map.put(x, 1);
            }
        }
        System.out.println(map.size());
        int count = 0;
        if(map.containsKey(key)){
            count = map.get(key);
        }
        System.out.println(count);
    }
}