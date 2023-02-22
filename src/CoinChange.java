import java.util.Arrays;
import java.util.stream.IntStream;

public class CoinChange {

  public static void main(String[] args) {

    int[] coins = {1};
    System.out.println(minimumCoinChange(0, coins));

    //System.out.println(count(coins, coins.length, 4));
  }

  //Using bottom top DP approach
  public static int minimumCoinChange(int change, int[] denominations) {
    var dpSize = change + 1;
    var dp = new int[dpSize];
    for (var i = 1; i <= change; i++) {
      dp[i] = dpSize;
    }
    dp[0] = 0;

    for (var i = 0; i < dpSize; i++) {
      for (var denomination : denominations) {
        if (i - denomination >= 0) {
          dp[i] = Math.min(dp[i], 1 + dp[i - denomination]);
        }
      }
    }
    return dp[change] != dpSize ? dp[change] : -1;
  }

  public static int sumCoinChange(int n, int[] coins) {
    int[] dp = new int[n + 1];
    dp[0] = 1;

    for (int i = 0; i < n + 1; i++) {
      for (var coin : coins) {
        if (i - coin >= 0) {
          dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
        }
      }
    }

    return dp[n];
  }

    public static long count(int coins[], int n, int sum)
    {
      int table[] = new int[sum + 1];
      table[0] = 1;
      for (int i = 0; i < n; i++)
        for (int j = coins[i]; j <= sum; j++)
          table[j] += table[j - coins[i]];
      return table[sum];
    }

}
