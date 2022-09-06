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
        System.out.println(calculate(e));
    }

    public static int calculate(String s) {
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



}
