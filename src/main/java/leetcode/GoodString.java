package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class GoodString {

    public static void main(String[] args) {
        String s = "abBAcC";
        System.out.println(makeGood2(s));
    }

    public static String makeGood(String s) {
        if(s.length()<2){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        stack.add(s.charAt(0));
        for(int i =1;i<s.length();i++){
            if(!stack.isEmpty() && isMatch(stack.peek(), s.charAt(i))){
                stack.pop();
            }  else{
                stack.push(s.charAt(i));
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pollFirst());
        }
        return sb.reverse().toString();
    }

    public static String makeGood2(String s){
        if(s.length()<2){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() ; i++) {
            if(!sb.isEmpty() && isMatch(s.charAt(i),sb.charAt(sb.length()-1))){
               sb.deleteCharAt(sb.length()-1);
               continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static boolean isMatch(char a,char b){
        return Math.abs(a- b) == 32;
    }
}
