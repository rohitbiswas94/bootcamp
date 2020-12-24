/*
Find minimum number of coins that make a given value
 */
package dynamicProgramming;

import java.util.Arrays;

public class MinimumCoinChangeProblem {

    //Top Down Approach
    private static int minCoins(int n, int arr[], int dp[]) {
        if (n == 0) return 0;
        int minCoins = Integer.MAX_VALUE;
        for (int index = 0; index < arr.length; index++) {
            if (n - arr[index] >= 0) {
                int subMinCoins;
                if (dp[n - arr[index]] == -1) {
                    subMinCoins = minCoins(n - arr[index], arr, dp);
                } else {
                    subMinCoins = dp[n - arr[index]];
                }
                if (subMinCoins + 1 < minCoins) {
                    minCoins = subMinCoins + 1;
                }
            }
        }
        dp[n] = minCoins;
        return minCoins;
    }

    //Bottom Up Approach
    private static int minCoins(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= amount; ++j) {
                if (j == 0)
                    dp[i][j] = 0;
                else if (i == 0)
                    dp[i][j] = 100000;
                else if (coins[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
            }
        }
        return dp[n][amount] > 1e4 ? -1 : dp[n][amount];
    }

    public static void main(String args[]) {
        int[] coins = {2};
        int totalAmount = 3;
        int dp[] = new int[totalAmount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        int minCoins = minCoins(totalAmount, coins);
        System.out.println(minCoins);
    }
}
