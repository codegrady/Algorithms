package leetcode;

/**
 * 给定一个数n，所有人的编号从 0 到 n-1
 * 给定一个函数 boolean know(int i,int j),
 * 该函数表示i这个人认不认识j这个人，认识关系是单向的
 * 有了这个函数，你可以检查认识这件事情
 * 规定何为明星
 * 1 所有人都认识这个人
 * 2 这个人不认识自己之外的所有人
 * 那么这个人就是明星
 * 利用 know 函数，找到明星，返回明星的编号，如果没有就返回-1.
 *
 * https://leetcode.cn/problems/find-the-celebrity/
 *
 * 思路：
 *     认为0是候选明星，遍历数字，如果不认识，跳下一个；认识，当前为新的候选明星 直到遍历结束
 *     然后 再遍历一遍，确认都认识他，他不认识所有人
 */
public class FindTheCelebrity {


    public static void find(int n){
        int cele = 0;
        for (int i = 1; i < n; i++) {

        }
    }

    public static  boolean know(int i,int j){

        return false;
    }
}
