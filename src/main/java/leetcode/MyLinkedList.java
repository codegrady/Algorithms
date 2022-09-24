package leetcode;

import java.util.LinkedList;
import java.util.TreeMap;

/**
 *  https://leetcode.cn/problems/design-linked-list/
 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引
 用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。

 在链表类中实现这些功能：

 get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加到链
 表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。

 示例：
 MyLinkedList linkedList = new MyLinkedList();
 linkedList.addAtHead(1);
 linkedList.addAtTail(3);
 linkedList.addAtIndex(1,2);   //链表变为 1-> 2-> 3
 linkedList.get(1);            //返回2
 linkedList.deleteAtIndex(1);  //现在链表是 1-> 3
 linkedList.get(1);            //返回3

 提示：
 所有val值都在 [1, 1000] 之内。
 操作次数将在 [1, 1000] 之内。
 请不要使用内置的 LinkedList 库。
 Related Topics 设计 链表 👍 628 👎 0

 */
public class MyLinkedList {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        int x = 0;
        list.addAtHead(0);
        System.out.println(x++);
        list.addAtIndex(1,4);
        System.out.println(x++);
        list.addAtTail(8);
        System.out.println(x++);
        list.addAtHead(5);
        list.addAtIndex(4,3);
        System.out.println(x++);
        list.addAtTail(0);
        list.addAtTail(5);
        System.out.println(x++);
        list.addAtIndex(6,3);
        list.deleteAtIndex(7);
        list.deleteAtIndex(5);
        System.out.println(x++);
        list.addAtTail(4);
    }

    private int length;
    private DoubleListNode head;
    private DoubleListNode tail;

    public MyLinkedList() {
        head = tail = null;
        length = 0;
    }

    public int get(int index) {
        if(index<0 || index >= length){
            return -1;
        }
        int x = 0;
        DoubleListNode temp = head;
        while (temp.next != null && x<index){
            x++;
            temp = temp.next;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        DoubleListNode node = new DoubleListNode(val);
        if(head == null){
            head = tail = node;
        }else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        length++;
    }

    public void addAtTail(int val) {
        DoubleListNode node = new DoubleListNode(val);
        if(head == null){
            head = tail = node;
        }else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        length++;
    }

    public void addAtIndex(int index, int val) {
        if( index > length){
            return ;
        }
        if(index <= 0){
            addAtHead(val);
        }else if(index == length){
            addAtTail(val);
        }else {
            DoubleListNode node = new DoubleListNode(val);
            DoubleListNode temp = head;
            int x = 0;
            while (x<index){
                temp = temp.next;
                x++;
            }
            node.prev = temp.prev;
            temp.prev.next = node;
            node.next = temp;
            temp.prev = node;
            length++;
        }
    }

    public void deleteAtIndex(int index) {
        if(index<0 || index >= length){
            return ;
        }

        if(length == 1){
          head = tail = null;
        } else if(index == 0){
            head = head.next;
            head.prev = null;
        }else if(index == length-1){
            tail = tail.prev;
            tail.next = null;
        }else {
            DoubleListNode temp = head;
            int x = 0;
            while (x < index) {
                temp = temp.next;
                x++;
            }
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        length--;
    }
    class DoubleListNode{
        DoubleListNode prev = null;
        int val;
        DoubleListNode next = null;

        public DoubleListNode(int val){
            this.val = val;
        }
    }
}
