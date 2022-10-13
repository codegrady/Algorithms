package leetcode;

public class IncreasingMinSwap {

    public static int minSwap(int[] nums1, int[] nums2) {
        int step = 0;
        int n = nums1.length;
        for (int i = 1; i < n; i++) {
            if(nums1[i-1]>=nums1[i]||nums2[i-1]>=nums2[i]){
                int temp = nums1[i-1];
                nums1[i-1] = nums2[i-1];
                nums2[i-1] = temp;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums1 = {3,3,8,9,10}, nums2 = {1,7,4,6,8};
        System.out.println(minSwap(nums1, nums2));
    }
}
