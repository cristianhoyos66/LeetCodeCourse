package stacks;

import java.util.Stack;

public class RemoveAllAdjacentDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    private static String removeDuplicates(String s) {
        var result =  new StringBuilder();
        var stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            var ch = s.charAt(i);
            if (!stack.isEmpty() && stack.peek().equals(ch)) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

}
