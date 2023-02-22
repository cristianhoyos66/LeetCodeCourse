package twopointers;

public class TwoPointersTwoSum {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    System.out.println(twoSum(arr, 9));
  }

  public static boolean twoSum(int[] arr, int target) {
    var left = 0;
    var right = arr.length - 1;

    while(left < right) {
      if (arr[right] > target) {
        right--;
      } else {
        if (arr[left] + arr[right] == target) {
          return true;
        } else {
          left++;
        }
      }
    }
    return false;
  }

}
