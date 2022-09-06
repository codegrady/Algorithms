package newcoder.huawei;

import java.util.Scanner;

/**
 * 描述
    计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
    输入描述：
    输入一行，代表要计算的字符串，非空，长度小于5000。

    输出描述：
    输出一个整数，表示输入字符串最后一个单词的长度。
    示例1
        输入：hello nowcoder

        输出：8

        说明：最后一个单词为nowcoder，长度为8   
 */
public class HJ001_LastWord{
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();
        reverse(str);
    }

    private static void lastBlank(String str){
        int blankIndex = str.lastIndexOf(" ");
        System.out.println(str.substring(blankIndex+1).length());
    }

    private static void reverse(String str){
        if(str.length() < 1){
            return;
        }
        int count = 0;
        for(int x = str.length()-1 ; x>=0;x--){
            if(str.charAt(x) == ' '){
                break;
            }
            count ++;
        }
        System.out.println(count);
    }
}