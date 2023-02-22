package prefixsum;

import java.util.Arrays;

public class SubarraySumValidation {

  public static void main(String[] args) {

    int[] nums = {1, 6, 3, 2, 7, 2};
    int[][] queries = {{0, 3}, {2, 5}, {2, 4}};
    int limit = 13;
    System.out.println(Arrays.toString(subArrayValidation(nums, queries, limit)));
  }

  private static boolean[] subArrayValidation(int[] nums, int[][] q, int limit) {
    boolean[] res = new boolean[q.length];
    int[] pSum = getPrefixSum(nums);
    for (int i = 0; i < q.length; i++) {
      var coordinates = q[i];
      var l = coordinates[0];
      var r = coordinates[1];
      res[i] = pSum[r] - pSum[l] + nums[i] < limit;
    }
    return res;
  }

  private static int[] getPrefixSum(int[] nums) {
    int[] pSum = new int[nums.length];
    pSum[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      pSum[i] = pSum[i - 1] + nums[i];
    }
    return pSum;
  }

}
