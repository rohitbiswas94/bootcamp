package dynamicProgramming;

import java.util.Arrays;

public class KnapsackProblem {

    private static int knapsack(int[] weights, int[] value, int totalCapacity) {
        int[][] dp = new int[weights.length+1][totalCapacity+1];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }

        for (int i = 1; i <= weights.length; i++) {
            for (int j = 1 ; j <= totalCapacity; j++) {
                if (weights[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(
                            dp[i-1][j],
                            value[i-1] + dp[i-1][j - weights[i-1]]);
                }
            }
        }
        return dp[weights.length][totalCapacity];
    }

    public static void main(String args[]) {
        int totalCapacity = 10;
        int[] weights = {1,3,4,6};
        int[] value = {20,30,10,50};
        int maxProfit = knapsack(weights, value, totalCapacity);
        System.out.println("The maximum profit is : " + maxProfit);
    }
}
