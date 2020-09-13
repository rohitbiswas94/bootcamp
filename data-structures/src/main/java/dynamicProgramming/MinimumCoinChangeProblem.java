/*
Find minimum number of coins that make a given value
 */
package dynamicProgramming;

import java.util.Arrays;

public class MinimumCoinChangeProblem {

    private static int minCoins(int n, int arr[], int dp[]) {
        if(n == 0) return 0;
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

    public static void main(String args[]) {
        int arr[] = {7,5,1};
        int n = 18;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        int minCoins = minCoins(n, arr, dp);
        System.out.println("The minimum number of coins to get " + n + " is : " + minCoins);
    }
}
