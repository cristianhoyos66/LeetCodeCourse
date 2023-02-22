package slidingwindow;

public class MaxConsecutiveOnes {


  public static void main(String[] args) {
    int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
    System.out.println(getMaxConsecutiveOnes(arr, 2));
  }

  public static int getMaxConsecutiveOnes(int[] nums, int k) {
    int zeroCount = 0;
    int start = 0, res = 0;
    for (int end = 0; end < nums.length; end++) {
      if (nums[end] == 0) {
        zeroCount++;
      }
      if (zeroCount > k) {
        if (nums[start] == 0) {
          zeroCount--;
        }
        start++;
      }
      res = Math.max(res, end - start + 1);
    }
    return res;
  }

}
