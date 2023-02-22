package slidingwindow;

public class MaximumAverageSubArray {

  public static void main(String[] args) {
    //int[] nums = {1,12,-5,-6,50,3};
    int[] nums = {-1};

    System.out.println(getMaxAvg(nums, 1));
  }

  public static double getMaxAvg(int[] nums, int k) {
    double sum=0;
    for(int i=0;i<k;i++)
      sum+=nums[i];
    double res=sum;
    for(int i=k;i<nums.length;i++){
      sum+=nums[i]-nums[i-k];
      res=Math.max(res,sum);
    }
    return res/k;
  }

}
