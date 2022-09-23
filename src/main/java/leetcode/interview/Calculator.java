package leetcode.interview;

import java.util.Stack;

/**
 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。

 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。

 示例 1:

 输入: "3+2*2"
 输出: 7


 示例 2:

 输入: " 3/2 "
 输出: 1

 示例 3:

 输入: " 3+5 / 2 "
 输出: 5


 说明：


 你可以假设所给定的表达式都是有效的。
 请不要使用内置的库函数 eval。


 Related Topics 栈 数学 字符串 👍 83 👎 0

 */
public class Calculator {

    public static void main(String[] args) {

//        char c = '3';
//        System.out.println(Character.isDigit(c));

       String e = "3+5/2";
        System.out.println(simpleCalculate(e));
    }

    /**
     * + - * / 四种运算符
     * @param s
     * @return
     */
    public static int simpleCalculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        // 前一个运算符
        char preSign = '+';
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(Character.isDigit(cur)){
                num = num * 10 + (cur-'0');
            }
            if(!Character.isDigit(cur) && cur != ' ' || i == s.length()-1){
                switch (preSign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case  '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                num = 0;
                preSign = s.charAt(i);
            }

        }

        int res = 0;
        while (!stack.isEmpty()){
            res +=stack.pop();
        }
        return res;
    }

    /**
     * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
     * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
     *
     * 输入：s = "1 + 1"
     * 输出：2
     *
     * 输入：s = " 2-1 + 2 "
     * 输出：3
     *
     * 输入：s = "(1+(4+5+2)-3)+(6+8)"
     * 输出：23
     * ‘
     * + - （ ）
     * @param s
     * @return
     */
    public static int simpleBraCal(String s){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        int sign = 1;
        int ret = 0;
        int length = s.length(),i=0;
        while (i<length){

        }
        return 0;
    }

}
