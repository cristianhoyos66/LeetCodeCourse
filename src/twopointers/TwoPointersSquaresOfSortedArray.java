package twopointers;

public class TwoPointersSquaresOfSortedArray {

  public static void main(String[] args) {

  }

  public static int[] squaresOfSortedArray(int[] sortedArray) {
    int n = sortedArray.length;
    int[] result = new int[n];
    int left = 0;
    int right = n - 1;

    for (int i = n - 1; i >= 0; i--) {
      int square;
      if (Math.abs(sortedArray[left]) < Math.abs(sortedArray[right])) {
        square = sortedArray[right];
        right--;
      } else {
        square = sortedArray[left];
        left++;
      }
      result[i] = square * square;
    }
    return result;
  }

}
