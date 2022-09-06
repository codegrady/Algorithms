package newcoder.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 记负均正
 * 首先输入要输入的整数个数n，然后输入n个整数。输出为n个整数中负数的个数，和所有正整数的平均值，结果保留一位小数。
 * 0即不是正整数，也不是负数，不计入计算。如果没有正数，则平均值为
 * 输入描述：
 *   首先输入一个正整数n，
 *   然后输入n个整数。
 * 输出描述：
 *   输出负数的个数，和所有正整数的平均值。
 * =========================
 * 输入：
 *     11 
 *     1 2 3 4 5 6 7 8 9 0 -1
 * 输出：
 *     1 5.0
 */
public class HJ097_PosiNega {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        int  posiCount = 0, negaCount = 0;
        double sum = 0.0 ,avg = 0.0;
        for(int i = 0;i<nums.length;i++){
            int x = Integer.parseInt(nums[i]);
            if(x>0){
                sum += x;
                posiCount++;
            }
            if(x<0){
                negaCount++;
            }
        }
        if(posiCount>0){
            avg = sum/posiCount;
        }
        
        System.out.println(negaCount + " " + String.format("%.1f",avg));
    }
}
