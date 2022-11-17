package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FruitTrees {

    public static void main(String[] args) {
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(fruits));
    }

    public static int totalFruit(int[] fruits) {
        int left=0,right=0,res=0,N=fruits.length,max=0;
        Map<Integer,Integer> map = new HashMap<>(2);
        while (left<=right && right<N){
            if(map.containsKey(fruits[right])){
                map.put(fruits[right],map.get(fruits[right])+1);
                right++;
                res++;
            }else if(map.size()<2){
                map.put(fruits[right],1);
                right++;
                res++;
            }else {
                int l = map.get(fruits[left]);
                if(l==1){
                    map.remove(fruits[left]);
                }else {
                    map.put(fruits[left],l-1);
                }
                left++;
                res--;
            }
           max = Math.max(res,max);
        }
        return max;
    }
}
