package other;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 将IP 转成 数字， 并 保证 可以来回 转换
 * 思路：
 *  1. long， 直接拼接
 *  2. int ， IP是由32位，同样，int 也是32为组成的，采用左移的方式
 */
public class IpToInt {

    public static void main(String[] args) {
        String ip = "123.114.114.114";
        int num = ipToInt(ip);
        System.out.println(num);
        System.out.println(intToIp(num));
    }

    public static int ipToInt(String ip){
        int x = 0;
        String[] nums = ip.split("\\.");
        for (int i = 0; i < nums.length; i++) {
            int n = Integer.parseInt(nums[i]);
            System.out.println("n = " + n);
            x = (x << 8) + n;
        }
        return  x;
    }

    public static String intToIp(int num){
        String[] array = new String[4];

        for (int i = array.length -1; i >= 0 ; i--) {
            array[i] = num%256+"";
            num = num>>8;
        }
        return Arrays.stream(array).collect(Collectors.joining("."));
    }
}
