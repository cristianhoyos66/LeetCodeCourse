package stacks;

import java.util.Stack;

public class MonotonicStack {

  public static void main(String[] args) {
    System.out.println(pushToMonotonicStack(new int[] {1, 2, 3, 10, 20, 5}));
  }

  public static Stack<Integer> pushToMonotonicStack(int[] n) {
    var stack = new Stack<Integer>();
    for (int i = 0; i < n.length; i++) {
      var number = n[i];
      while (!stack.isEmpty() && stack.peek() > number) {
        stack.pop();
      }
      stack.push(number);
    }
    return stack;
  }
}
