package prefixsum;

import java.util.Arrays;

public class RunninSum {

    public static void main(String[] args) {
        int[] arr = {3,1,2,10,1};
        System.out.println(Arrays.toString(getPrefix(arr)));
    }

    private static int[] getPrefix(int[] arr) {
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        return prefix;
    }

}
