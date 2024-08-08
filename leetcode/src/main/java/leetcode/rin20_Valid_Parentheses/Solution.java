package leetcode.rin20_Valid_Parentheses;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }else {
                if (!stack.isEmpty()) {
                    char peek = stack.peek();
                    if (c == ')' && peek == '(' || peek == '{' && c == '}' || peek == '[' && c == ']'){
                        stack.pop();
                    } else {
                        return false;
                    }
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("]"));
    }
}
