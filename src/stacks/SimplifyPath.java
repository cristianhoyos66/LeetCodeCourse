package stacks;

import java.util.Stack;

public class SimplifyPath {
  public static void main(String[] args) {
    System.out.println(simplify("/home//foo/"));
  }

  private static String simplify(String path) {
    var stack = new Stack<String>();
    String[] dirs = path.split("/");
    for (int i = 0; i < dirs.length; i++) {
      var dir = dirs[i];
      if (dir.equals("..")) {
        if (!stack.empty()) {
          stack.pop();
        }
      } else if (!dir.equals(".") && !dir.equals("")) {
        stack.push(dir);
      }
    }
    return "/" + String.join("/", stack);
  }
}
