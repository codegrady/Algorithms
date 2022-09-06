package leetcode;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * 示例 1：
 *
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 *
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * 提示：
 *
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 * Related Topics
 * 数组
 * 哈希表
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{2, 4, 5, 3, 3, 1}));
    }

    public static int firstMissingPositive(int[] nums) {
        int L = 0;
        int R = nums.length;
        while (L!=R){
            if(nums[L] == L+1){
                L++;
            } else if (nums[L] <= L || nums[L] > R || nums[nums[L]-1] == nums[L]) {
                swap(nums,L,--R);
            }else {
                swap(nums,L,nums[L]-1);
            }
        }

        return L + 1;
    }

    public static void swap(int[] nums,int src,int dist){
        int temp = nums[src];
        nums[src] = nums[dist];
        nums[dist] = temp;
    }
}
