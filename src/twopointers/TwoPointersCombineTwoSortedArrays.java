package twopointers;

import java.util.Arrays;

public class TwoPointersCombineTwoSortedArrays {

  public static void main(String[] args) {
    int[] arr1 = {1, 2, 3, 4};
    int[] arr2 = {2, 6, 10, 154};
    System.out.println(Arrays.toString(combineTwoSortedArrays(arr1, arr2)));
  }

  public static int[] combineTwoSortedArrays(int[] arr1, int[] arr2) {
    int i = 0;
    int j = 0;
    int[] res = new int[arr1.length + arr2.length];
    int resIdx = 0;

    while (i < arr1.length && j < arr2.length) {
      if (arr1[i] < arr2[j]) {
        res[resIdx++] = arr1[i++];
      } else {
        res[resIdx++] = arr2[j++];
      }
    }

    while (i < arr1.length) {
      res[resIdx++] = arr1[i++];
    }

    while (j < arr2.length) {
      res[resIdx++] = arr2[j++];
    }
    return res;
  }

}
