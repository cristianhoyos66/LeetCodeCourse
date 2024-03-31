package prefixsum;

public class MinimumValueGetPositive {

    public static void main(String[] args) {
        int[] nums = {2,3,5,-5,-1};
        System.out.println(minStartValue(nums));
    }

    private static int minStartValue(int[] nums) {
        var prefix = getPrefixSum(nums);
        var min = prefix[0];
        for (int i = 1; i < prefix.length; i++) {
            min = Math.min(min, prefix[i]);
        }
        return min < 1 ? Math.abs(min - 1) : 1;
    }

    private static int[] getPrefixSum(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        return prefix;  
    }

}
