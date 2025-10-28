package stacks;

import java.util.*;

public class NextGreaterElement {

  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(nextGreaterElement(new int[] {4, 1, 2}, new int[] {1, 3, 4, 2})));
  }

  public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
    var res = new int[nums1.length];
    Arrays.fill(res, -1);
    var map = createMap(nums1);
    Deque<Integer> stack = new ArrayDeque<>();
    for (int num : nums2) {
      while (!stack.isEmpty() && stack.peek() < num) {
        int smaller = stack.pop();
        Integer idx = map.get(smaller);
        if (idx != null) {
          res[idx] = num;
        }
      }
      stack.push(num);
    }
    return res;
  }

  private static Map<Integer, Integer> createMap(int[] nums1) {
    var map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums1.length; i++) {
      map.put(nums1[i], i);
    }
    return map;
  }
}
