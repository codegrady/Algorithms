package leetcode;

import java.util.Arrays;
import java.util.Objects;

/**
 * 1465
 */
public class MaxAreaCake {

    public static void main(String[] args) {
        int h = 1000000000,w = 1000000000;
        int[] horizontalCuts = {2}, verticalCuts = {2};
        System.out.println(maxArea(h, w, horizontalCuts, verticalCuts));
    }

    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int[] allH = new int[horizontalCuts.length+2];
        int[] allW = new int[verticalCuts.length+2];

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        allW[0]=0;allH[0]=0;
        for (int i = 0; i < horizontalCuts.length; i++) {
            allH[i+1] = horizontalCuts[i];
        }
        allH[allH.length-1] = h;

        for (int i = 0; i < verticalCuts.length; i++) {
            allW[i+1] = verticalCuts[i];
        }
        allW[allW.length-1] = w;

        long maxH=0, maxW=0;

        for (int i = 1; i < allH.length; i++) {
            maxH = Math.max(allH[i] - allH[i-1],maxH);
        }

        for (int i = 1; i < allW.length; i++) {
            maxW = Math.max(allW[i] - allW[i-1],maxW );
        }
        long ret = maxH * maxW;
        return ret>Integer.MAX_VALUE?(int)(ret%((long)(Math.pow(10,9)+7))):(int)ret;
    }
}
