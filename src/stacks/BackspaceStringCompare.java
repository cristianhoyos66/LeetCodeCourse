package stacks;

public class BackspaceStringCompare {

    public static void main(String[] args) {
        System.out.println(backspaceCompare("y#fo##f", "y#f#o##f"));
    }

    public static boolean backspaceCompare(String s, String t) {
        var strS = cleanStr(s);
        var strt = cleanStr(t);

        return strS.equals(strt);
    }

    private static String cleanStr(String s) {
        var strS = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!strS.isEmpty() && c == '#') {
                strS.deleteCharAt(strS.length() - 1);
            } else if (c != '#') {
                strS.append(c);
            }
        }
        return strS.toString();
    }
}
