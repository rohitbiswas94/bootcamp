/*
    Number of ways the sum can be formed using (1 to k) integers. Repetition is allowed.
 */

package arrays;

public class NumberOfWays {

    public static int ways(int total, int k) {
        int[][] dp = new int[k + 1][total + 1];
        for (int i = 0; i <= total; i++) {
            dp[0][i] = 1;
            dp[1][i] = 1;
        }

        for (int i = 0; i <= k; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= total; j++) {
                if (i <= j) {
                    dp[i][j] = 1 + dp[i][j - i];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[k][total];
    }

    public static void main(String[] args) {
        int total = 8;
        int k = 2;
        System.out.println(ways(total, k));
    }
}
