package hashing;

import java.util.Set;

public class MaximumNumberOfBalloons {

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
    }

    private static int maxNumberOfBalloons(String text) {
        var map = Set.of('b', 'a', 'l', 'o', 'n');
        var res = 0;
        for (int i = 0; i < text.length(); i++) {
            var ch = text.charAt(i);
            if (map.contains(ch)) {
                res++;
            }
        }
        return res == 0 ? res : res / 7;
    }

}
