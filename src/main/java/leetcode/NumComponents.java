package leetcode;

import leetcode.entity.ListNode;

import java.util.*;

public class NumComponents  {
    public static void main(String[] args) {
        ListNode head = new ListNode(0,new ListNode(1,new ListNode(2)));
        int[] num = {1,0};
        System.out.println(numComponents(head, num));
    }


    public static int numComponents(ListNode head, int[] nums) {
        if(nums.length ==0){
            return 1;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        boolean lastHas= false;
        int num = 0;

        while (head !=null){
            if(!set.contains(head.val) && lastHas){
                num++;
            }
            lastHas = set.contains(head.val);
            head = head.next;
        }

        if(lastHas){
            num+=1;
        }
        return num;
    }
}
