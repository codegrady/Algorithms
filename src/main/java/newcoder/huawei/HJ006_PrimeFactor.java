package newcoder.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 质数因子
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 */
public class HJ006_PrimeFactor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int factor = 2;
        int x = (int)Math.sqrt(num);
        while(factor <= x){
            if(num % factor == 0){
                System.out.print(factor +" ");
                num /= factor;
            }else{
                factor++;
            }
        }
        if(num != 1){
            System.out.print(num);
        }
    }
}
