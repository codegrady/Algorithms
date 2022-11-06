package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode 904
 * @author Grady
 */
public class FruitTree {
    public static void main(String[] args) {

    }

    public static int totalFruit(int[] fruits) {
        int left=0,right = 0,ret = 0;
        Set<Integer> set = new HashSet<>(2);
        while (left<= right && right<fruits.length){
            if(set.size()<2){
                right++;
                ret++;
            }
        }

        return 0;
    }
}
