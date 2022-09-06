package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gongyu
 * @Title: TwoNumSum
 * @ProjectName leetcode
 * @Description: TODO 两数之和 在数组中找到两个数之和为目标数，并返回数组索引
 * @date 2021/9/5
 */
public class TwoNumSum {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {

        // 1 数组双循环方式 时间复杂度： O(n2)
        for(int i=0;i<nums.length;i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[i]+nums[j]==target){
                    int[] result = {i,j};
                    return result;
                }
            }
        }

        //2 哈希方式
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }
            map.put(target-nums[i],i);
        }
        return null;
    }
}