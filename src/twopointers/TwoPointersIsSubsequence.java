package twopointers;

public class TwoPointersIsSubsequence {

  public static void main(String[] args) {
    System.out.println(isSubsequence("abcde", "ace"));
  }

  public static boolean isSubsequence(String t, String s) {
    int i = 0;
    int j = 0;

    while (i < s.length() && j < t.length()) {
      if (s.charAt(i) == t.charAt(j)) {
        i++;
      }
      j++;
    }
    return i == s.length();
  }

}
