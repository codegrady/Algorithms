package leetcode;

public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {0,0,0,0,0};
        int[] nums2 = {-1,0,0,0,0,0,1};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null){
            nums1 = new int[0];
        }
        if(nums2 == null){
            nums2 = new int[0];
        }
        int total = nums1.length + nums2.length;
        int target = total/2;
        boolean isOdd = total%2==1;
        if(nums1.length == 0){
            return isOdd?nums2[target]:((double) (nums2[target -1]+nums2[target]))/2;
        }else if(nums2.length == 0){
            return isOdd?nums1[target]:((double) (nums1[target -1]+nums1[target]))/2;
        }else {
            int index = 0,idx1 = 0, idx2 = 0;
            int midBefore = 0,midAfter = 0;
            while (index<=target && idx1 < nums1.length && idx2 < nums2.length){
                int cur = 0;
                if(nums1[idx1] <= nums2[idx2]){
                    cur = nums1[idx1];
                    idx1 ++;
                }else if(nums2[idx2] < nums1[idx1] ){
                    cur = nums2[idx2];
                    idx2 ++;
                }
                System.out.println("cur = " + cur);
                if(index == target-1){
                    midBefore = cur;
                }
                if(index == target){
                    midAfter = cur;
                }
                index++;
            }
            System.out.println("idx1:"+idx1+" idx2:"+idx2);
            System.out.println("index:"+index+" target:"+target);
            System.out.println("midBefore:"+midBefore+" midAfter:"+midAfter);
            if(index<target||midAfter==0){
                //数组1 跑完了
                if(nums1.length == idx1){
                    if(index < target) {
                        midBefore = nums2[idx2 + (target - 1 - index)];
                    }
                    midAfter = nums2[idx2 + (target  - index)];
                }else {
                    if(index < target) {
                        midBefore = nums1[idx1 + (target - 1 - index)];
                    }
                    midAfter = nums1[idx1 + (target  - index)];
                }
            }

            return isOdd?midAfter:((double) (midBefore+midAfter))/2;

        }

    }
}
