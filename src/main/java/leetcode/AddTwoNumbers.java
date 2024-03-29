package leetcode;

import entity.ListNode;

/**
 * https://leetcode.cn/problems/add-two-numbers/
 *
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 示例 1：
 *![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/01/02/addtwonumber1.jpg)
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
//        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode l2 = new ListNode(1);
//        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4)));

        ListNode listNode = add2(l1,l2);
        while (listNode!=null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }

        ListNode root = new ListNode(0);
        ListNode cur = root;
        int up = 0;
        while (l1 != null || l2 != null || up != 0){
            int a = l1 == null?0:l1.val;
            int b = l2 == null?0:l2.val;
            int total = a + b + up;
            up = total/10;
            cur.next = new ListNode(total%10);
            cur = cur.next;

            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }

        if(up !=0){
            cur.next = new ListNode(up);
        }
        return root.next;
    }

    static int quotient = 0;
    static int remainder = 0;
    public static ListNode add2(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null){
            if(quotient > 0){
                return new ListNode(quotient);
            }
            return null;
        }else if(l1 == null){
            remainder = (l2.val + quotient) % 10;
            quotient = (l2.val + quotient) / 10;
            return new ListNode(remainder,add2(null,l2.next));
        }else if(l2 == null){
            remainder = (l1.val + quotient) % 10;
            quotient = (l1.val + quotient) / 10;
            return new ListNode(remainder,add2(l1.next,null));
        }else{
            remainder = (l1.val + l2.val + quotient) % 10;
            quotient = (l1.val + l2.val + quotient) / 10;
            return new ListNode(remainder,add2(l1.next,l2.next));
        }
    }
}
