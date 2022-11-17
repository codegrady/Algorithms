package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 1678
 */
public class GoalCommand {

    public static void main(String[] args) {
        String command = "(al)G(al)()()G";
        System.out.println(interpret(command));
    }

    public static String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        char lastC = '0';
        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            if(c == 'G'){
                sb.append("G");
            }else if(c == '(' || c == 'a'){
                lastC = c;
            }else if(c == ')' && lastC == '('){
                sb.append("o");
                lastC = '0';
            }else if(c == 'l' && lastC == 'a'){
                sb.append("al");
                lastC = '0';
            }
        }
        return sb.toString();
    }
}
