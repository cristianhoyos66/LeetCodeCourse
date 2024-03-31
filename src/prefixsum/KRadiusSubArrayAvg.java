package prefixsum;

import java.util.Arrays;

public class KRadiusSubArrayAvg {

    public static void main(String[] args) {
        int[] nums = {1000};
        int k = 0;
        System.out.println(Arrays.toString(getAverages(nums, k)));
    }

    public static int[] getAverages(int[] nums, int k) {
        if (k == 0) {
            return nums;
        } else {
            int[] avgs = new int[nums.length];
            var pSum = getPrefix(nums);
            for (int i = 0; i < nums.length; i++) {
                if (isValidLeft(k, i) && isValidRight(k, nums.length, i)) {
                    avgs[i] = getAvg(pSum, nums, i, k);
                } else {
                    avgs[i] = -1;
                }
            }
            return avgs;
        }
    }

    private static int getAvg(long[] pSum, int[] nums, int i, int k) {
        var start = i - k;
        var end = i + k;
        return (int) ((pSum[end] - pSum[start] + nums[start]) / (k + k + 1));
    }

    private static boolean isValidLeft(int k, int i) {
        return k - i <= 0;
    }

    private static boolean isValidRight(int k, int length, int i) {
        return length - 1 - i >= k;
    }

    private static long[] getPrefix(int[] nums) {
        long[] pSum = new long[nums.length];
        pSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pSum[i] = pSum[i - 1] + nums[i];
        }
        return pSum;
    }

}
