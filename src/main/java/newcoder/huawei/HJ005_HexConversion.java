package newcoder.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 进制转换
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 */
public class HJ005_HexConversion {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();;
        System.out.println(Integer.parseInt(str.substring(2), 16));
    }
}
