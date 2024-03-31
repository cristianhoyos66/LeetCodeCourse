package twopointers;

import java.util.Set;

public class ReverseOnlyLetters {

    public static void main(String[] args) {

        String s = ";1yDV";
        System.out.println(reverseOnlyLetters(s));
    }

    public static String reverseOnlyLetters(String s) {
        int l = 0, r = s.length() - 1;
        var res = new StringBuilder();
        while (r >= 0 || l < s.length()) {
            if (l < s.length()) {
                if (Character.isLetter(s.charAt(l))) {
                    while (!Character.isLetter(s.charAt(r))) {
                        r--;
                    }
                    res.append(s.charAt(r));
                    l++;
                    r--;
                } else {
                    res.append(s.charAt(l));
                    l++;
                }
            } else {
                return res.toString();
            }
        }
        return res.toString();
    }

}
