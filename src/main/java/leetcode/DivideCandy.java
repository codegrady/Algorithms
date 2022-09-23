package leetcode;

/**
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 你需要按照以下要求，给这些孩子分发糖果：
 *  -每个孩子至少分配到 1 个糖果。
 *  -相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 *
 * 示例1：
 *
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 示例2：
 *
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 *
 * 提示：
 * n == ratings.length
 * 1 <= n <= 2 * 104
 * 0 <= ratings[i] <= 2 * 104
 *
 * 链接：https://leetcode.cn/problems/candy
 */
public class DivideCandy {

    public static void main(String[] args) {
        int[] arr = {1,0,2};
        System.out.println(candy(arr));
    }

    /**
     * 思路：（左神 讲解）
     *    单调性：
     *      左 → 右 ： 开始为1 ，上升+1，否则 从1开始
     *      右 → 左 ： N-1为1 ，上升+1，否则 从1开始
     */
    public static int candy(int[] ratings) {
        int N = ratings.length;
        int[] left = new int[N],right = new int[N];
        left[0] = 1; right[N-1] = 1;
        for (int i = 1; i < N; i++) {
            if(ratings[i]>ratings[i-1]){
                left[i] = left[i-1] +1;
            }else {
                left[i] = 1;
            }
        }

        for (int i = N-2; i >= 0; i--) {
            if(ratings[i]>ratings[i+1]){
                right[i] = right[i+1] +1;
            }else {
                right[i] = 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Math.max(left[i],right[i]);
        }

        return sum;
    }
}
