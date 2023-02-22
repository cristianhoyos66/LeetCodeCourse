package twopointers;

import java.util.Arrays;

public class TwoPointersReverseString {

  public static void main(String[] args) {
    char[] s = {'h','e','l','l','o', '3'};
    System.out.println(Arrays.toString(reverse(s)));
  }

  public static char[] reverse(char[] s) {
    int left = 0;
    int right = s.length - 1;
    while (left < right) {
      var leftVal = s[left];
      s[left] = s[right];
      s[right] = leftVal;
      left++;
      right--;
    }
    return s;
  }

}
