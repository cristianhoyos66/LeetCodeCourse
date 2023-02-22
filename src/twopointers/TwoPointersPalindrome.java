package twopointers;

public class TwoPointersPalindrome {

  public static void main(String[] args) {
    var input = "abcccba";
    System.out.println(isPalindrome(input));
  }
  public static boolean isPalindrome(String input) {
    var start = 0;
    var end = input.length() - 1;
    while (start < end) {
      if (input.charAt(start) != input.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }

}
