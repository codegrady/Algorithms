package newcoder.huawei;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。
 * 如果小数点后数值大于等于 0.5 ,向上取整；小于 0.5 ，则向下取整。
 * 数据范围：保证输入的数字在 32 位浮点数范围内
 */
public class HJ007_ApproximateValue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double number = in.nextDouble();
        in.close();
        System.out.println((int)(number + 0.5));
    }
}
