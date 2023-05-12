package leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 餐盘 栈
 * 我们把无限数量 ∞ 的栈排成一行，按从左到右的次序从 0 开始编号。每个栈的的最大容量 capacity 都相同。
 *
 * LeetCode 1172
 */
public class DinnerPlates {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.set(1,2);
        System.out.println(list.size());
    }

    private int capacity;

    private int firstNotFullIndex = 0;

    /**
     * 数据
     */
    List<LinkedList<Integer>> data = new ArrayList<>();

    /**
     * 记录状态
     */
    List<Boolean> statusList = new ArrayList<>();

    /**
     * 给出栈的最大容量 capacity
     * @param capacity
     */
    public DinnerPlates(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 将给出的正整数 val 推入 从左往右第一个 没有满的栈
     * @param val
     */
    public void push(int val) {
        LinkedList<Integer> list = data.get(firstNotFullIndex);
        if(list == null){
            list = new LinkedList<>();
            if(statusList.get(firstNotFullIndex) == null){
                statusList.add(false);
            }
        }
        list.add(val);
        if(list.size() == capacity){
            statusList.set(firstNotFullIndex,true);
        }

    }

    /**
     * 返回 从右往左第一个 非空栈顶部的值，并将其从栈中删除；如果所有的栈都是空的，请返回 -1
     * @return
     */
    public int pop() {
        return 0;
    }

    /**
     * 返回编号 index 的栈顶部的值，并将其从栈中删除；如果编号 index 的栈是空的，请返回 -1
     * @param index
     * @return
     */
    public int popAtStack(int index) {
        LinkedList<Integer> list = data.get(index);
        if(list == null || list.size() == 0){
            return -1;
        }
        int ret = list.pop();
        statusList.set(index,false);
        return ret;
    }
}
