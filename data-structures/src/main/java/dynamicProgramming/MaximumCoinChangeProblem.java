/*
Given a value N, if we want to make change for N cents,
and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
Find the maximum possible ways to make the change
 */

package dynamicProgramming;

import java.util.Arrays;

public class MaximumCoinChangeProblem {

    private static int coins(int n, int coins[]) {
        if (n == 0) return 0;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int denomination  : coins) {
            for (int amount = 0; amount <= n; amount++) {
                if (denomination <= amount) {
                    dp[amount] = dp[amount - denomination] + dp[amount];
                }
            }
        }
        return dp[n];
    }

    // Second Approach
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        for (int i=1;i<=amount;i++)
            dp[0][i] = 0;
        for (int i=1;i<=coins.length;i++)
            dp[i][0] = 1;
        for (int i=1; i<=coins.length;i++) {
            for (int j=1; j<=amount; j++) {
                if (coins[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }
        }
        return dp[coins.length][amount];
    }


    public static void main(String args[]) {
        int coins[] = {3, 2, 6};
        int n = 10;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        int maxPossiblities = coins(n, coins);
        System.out.println("The maximum possible ways to get " + n + " is : " + maxPossiblities);
    }
}
