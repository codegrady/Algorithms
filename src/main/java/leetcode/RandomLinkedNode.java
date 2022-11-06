package leetcode;

import entity.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLinkedNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3)));
        RandomLinkedNode n = new RandomLinkedNode(head);
        for (int i = 0; i < 10; i++) {
            System.out.println(n.getRandom());
        }

    }

    private List<Integer> list;
    private ListNode head;
    Random random ;
    public RandomLinkedNode(ListNode head) {
        list = new ArrayList();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        random = new Random();
        System.out.println(list.size());
    }

    public int getRandom() {
        int r = random.nextInt(list.size());
        return list.get(r);
    }


}
