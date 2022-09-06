package leetcode;

import java.util.Arrays;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 提示：
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class FindMiedian {


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length =  nums1.length+nums2.length;
        boolean tag = length%2 == 1;
        int mid = length / 2;
        int s1 = 0,s2 = 0;
        while ((s1+s2)<mid){
            if(nums1[s1]<nums2[s2]){
                s1++;
            }else {
                s2++;
            }

        }

        return 0;
    }

    public static double find2(int[] nums1, int[] nums2){
        int len = nums1.length+nums2.length;
        int address1 = len/2,address1Num = 0,address2Num = 0;
        //address1Num代表最中间的数字 address2Num代表最中间数字左边的数字
        int n1 = 0, n2 = 0;
        int currentAddress = -1;
        while(currentAddress < address1){
            if(n1 < nums1.length&&n2 < nums2.length&&nums1[n1] < nums2[n2]||n2 >= nums2.length){
                //如果两个指针都在对应数组的范围内并且n1指向的数字比较小 或者 n2已经越界（没有数字可取了）
                address2Num = address1Num;
                address1Num = nums1[n1];
                n1++;
            }else{
                address2Num = address1Num;
                address1Num = nums2[n2];
                n2++;
            }
            currentAddress++;
        }
        //如果合并后是奇数 直接返回最中间的那个数字 否则返回两个数字的和除以2
        if(len%2 != 0){ return address1Num; }
        return (address1Num+address2Num)*1.0/2;
    }
}
