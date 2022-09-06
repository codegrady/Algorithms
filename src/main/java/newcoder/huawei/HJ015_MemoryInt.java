package newcoder.huawei;

import java.util.Scanner;

/**
 * 求int型正整数在内存中存储时1的个数
 *  这个数转换成2进制后，输出1的个数
 */
public class HJ015_MemoryInt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        in.close();
        int n = 0;
        //通过31次无符号右移，逐位与1进行与运算，结果为1则计数
        for(int i = 0; i<32;i++){
            if((x&1) == 1){
                n++;
            }
            x = x >>>1;
        }
        System.out.println(n);
    }
    
}
