package stacks;

import java.util.Stack;

public class DailyTemperatures {

  public static void main(String[] args) {
    var result = dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73});
    for (var r : result) {
      System.out.print(r + " ");
    }
  }

  public static int[] dailyTemperatures(int[] temperatures) {
    var res = new int[temperatures.length];
    var stack = new Stack<Integer>();
    for (int i = 0; i < temperatures.length; i++) {
      while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
        var lastIdx = stack.pop();
        res[lastIdx] = i - lastIdx;
      }
      stack.push(i);
    }
    return res;
  }
}
