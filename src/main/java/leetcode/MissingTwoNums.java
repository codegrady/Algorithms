package leetcode;

import java.util.Arrays;

/**
 * /**
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。
 * 你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 *
 *  以任意顺序返回这两个数字均可。
 *
 *  示例 1:
 *
 *  输入: [1]
 * 输出: [2,3]
 *
 *  示例 2:
 *
 *  输入: [2,3]
 * 输出: [1,4]
 *
 *  提示：
 *  nums.length <= 30000
 *
 *  Related Topics 位运算 数组 哈希表 👍 189 👎 0
 */
public class MissingTwoNums {

    public static void main(String[] args) {
        int[] nums = {1,3,4,5,6};

        int x = 0;
        for (int num : nums) {
            x ^=num;
            System.out.println("x = " + x);
        }
        System.out.println(Integer.toBinaryString(x));
//        System.out.println(Arrays.toString(missingTwo(nums)));
    }

    public static int[] missingTwo(int[] nums) {
        int N = nums.length;
        int[] ret = new int[2];
        boolean[] buf = new boolean[N+2];
        for (int i = 0; i < nums.length; i++) {
            buf[nums[i]-1] = true;
        }
        for (int i = 0; i < buf.length; i++) {
            if(!buf[i]){
                if(ret[0]==0){
                    ret[0] = i+1;
                }else {
                    ret[1] = i+1;
                }
            }
        }
        return ret;
    }


}
