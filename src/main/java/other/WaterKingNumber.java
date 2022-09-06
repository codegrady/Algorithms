package other;

import java.util.Objects;

/**
 * # 超级水王问题
 *
 * 在数组N中有 正、负、0，当出现次数大于N/2, 这个数是水王数。
 *
 * 用有限的几个变量，数组变量2遍来完成问题
 */
public class WaterKingNumber {

    public static void waterKing(int[] nums){
        if(Objects.isNull(nums) || nums.length == 0){
            System.out.println("没有水王数！");
        }
        int blood = 0,goal = 0;

        for (int i = 0; i < nums.length; i++) {
            if(blood ==0){
                goal = nums[i];
                blood ++;
            }else if(nums[i]==goal) {
                blood++;
            }else {
                blood --;
            }
        }

        if(blood ==0){
            System.out.println("没有水王数！");
            return;
        }

        int times = 0;
        for (int cur : nums) {
            if(cur == goal){
                times ++;
            }
        }

        if(times>nums.length/2){
            System.out.println("水王数是"+goal);
        }else {
            System.out.println("没有水王数！");
        }
    }
}
