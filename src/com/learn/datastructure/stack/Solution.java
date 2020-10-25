package com.learn.datastructure.stack;
import java.util.Stack;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-04 22:09 caibixiang Exp $
 */
public class Solution {


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char topChar = s.charAt(i);
            if (topChar == '(' || topChar == '[' || topChar == '{')
                stack.push(topChar);
            else {
                if (stack.isEmpty())
                    return false;

                char popChar = stack.pop();
                if (popChar == '(' && topChar!=')')
                    return false;
                if (popChar == '[' && topChar!=']')
                    return false;
                if (popChar == '{' && topChar!='}')
                if (popChar == '{' && topChar!='}')
                    return false;
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
       System.out.println(new Solution().isValid("(]"));
    }
}
