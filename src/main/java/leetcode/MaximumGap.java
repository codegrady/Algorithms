package leetcode;

import java.util.Objects;

public class MaximumGap {

    public static void main(String[] args) {
        int[] arra = {494767408,862126209,213511142,768240025,631263193,839199222,990848796,214568815,540853864,760724418,980162605,976743981,168965760,680875496,256709197,970953816,948680062,347254784,732201399,786249847,782805044,40906641,674241381,784330934,175502610,731105392,424650824,549764101,986090032,710542549,249208107,448419816,527708664,158499246,223421723,114552457,466978424,821491411,19614107,115389497,902211438,2644108,744489871,897895073,372311214,551142753,933294894,426217662,217504874,983488406,516890023,426853110,971124103};
        System.out.println(maximumGap(arra));
    }

    /**
     * 构建 N + 1 个桶 ，每个桶只保留最大和最小值
     * @param nums
     * @return
     */
    public static int maximumGap(int[] nums) {

        int N = nums.length;
        if(N < 2){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(num,min);
            max = Math.max(num,max);
        }

        if(min == max){
            return 0;
        }

        int[] mins = new int[N +1],
                maxs = new int[N + 1];
        boolean[] hasNum = new boolean[N +1];

        for (int num : nums) {
            int b = calBucket(num, N, min, max);
            mins[b] = hasNum[b]?Math.min(num,mins[b]):num;
            maxs[b] = hasNum[b]?Math.max(num,maxs[b]):num;
            hasNum[b] = true;
        }

        int maxGap = 0;
        int lastMax = maxs[0];
        for (int i = 1; i <= N ; i++) {
            if(hasNum[i]){
                maxGap = Math.max(maxGap,mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return maxGap;
    }

    private static int calBucket(long cur,long size,long min,long max){
        return (int) ((cur - min)*size/(max - min));
    }

}
