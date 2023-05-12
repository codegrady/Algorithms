package leetcode;

import java.util.Arrays;

/**
 * leetcode 1330
 */
public class MaxValueAfterReverse {
    public static void main(String[] args) {
        int[] nums = {5,-7,9,-6,8};
        System.out.println(maxValueAfterReverse(nums));
    }

    public static int maxValueAfterReverse(int[] nums) {
        if( nums.length == 1){
            return nums[0];
        }else if(nums.length == 2){
            return nums[0]+nums[1];
        }else {
            int maxSubSideSum=Integer.MIN_VALUE;
            int start = 0, end = 1;
            for(int s = 0;s<nums.length-1;s++){
                for (int e = s+1;e<nums.length;e++){
                    int cur = sideSum(nums,s,e);
                    System.out.println("==>cur = "+cur+" start = "+s + " end = "+e);
                    if(cur>maxSubSideSum){
                        maxSubSideSum = cur;
                        start = s;
                        end = e;
                        System.out.println("maxSubSideSum = " + cur+" start = "+start + " end = "+end);
                    }
                }
            }
            //new array
            int mid = (start+end)/2;
            for(int i = 0;i<= mid-start; i++){
                int tmp = nums[start+i];
                nums[start+i] = nums[end-i];
                nums[end-i] = tmp;
            }
            System.out.println("===========");
            int sum = 0;
            System.out.println("start = " + start);
            System.out.println("end = " + end);
            for (int i = 0; i < nums.length-1; i++) {
                sum += Math.abs(nums[i]-nums[i+1]);
            }
            System.out.println(Arrays.toString(nums));
            return sum;
        }
    }

    public static int sideSum(int[] nums,int start,int end){
        int before = 0,after =0;
        if(start > 0){
            before = Math.abs(nums[start-1] - nums[start]);
        }
        if(end < nums.length-1 ){
            after = Math.abs(nums[end] - nums[end+1]);
        }
        int oldSide = before+after;


        before = 0;after =0;
        if(start > 0){
            before = Math.abs(nums[start-1] - nums[end]);
        }
        if(end < nums.length-1 ){
            after = Math.abs(nums[start] - nums[end+1]);
        }
        int newSide = before+after;
        return newSide - oldSide;
    }
}
