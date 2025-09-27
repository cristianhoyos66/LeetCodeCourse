package stacks;

import java.util.Stack;

public class MakeStringGreat {
  public static void main(String[] args) {
    System.out.println(makeGood("abBAcC"));
  }

  public static String makeGood(String s) {
    var sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      var currentCh = s.charAt(i);
      if (sb.isEmpty()) {
        sb.append(currentCh);
      } else {
        var lastCh = sb.charAt(sb.length() - 1);
        if (Character.toLowerCase(lastCh) == Character.toLowerCase(currentCh)) {
          var isLastChLowerCase = Character.isLowerCase(lastCh);
          if (isLastChLowerCase) {
            var isCurrentChUpperCase = Character.isUpperCase(currentCh);
            if (isCurrentChUpperCase) {
              sb.deleteCharAt(sb.length() - 1);
            } else {
              sb.append(currentCh);
            }
          } else {
            var isCurrentChLowerCase = Character.isLowerCase(currentCh);
            if (isCurrentChLowerCase) {
              sb.deleteCharAt(sb.length() - 1);
            } else {
              sb.append(currentCh);
            }
          }
        } else {
          sb.append(currentCh);
        }
      }
    }
    return sb.toString();
  }
}
