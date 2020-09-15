package dynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {

    private static int lcs(char[] X, char[] Y, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }
        for (int row = 1; row <= m; row++) {
            for (int col = 1; col <= n; col++) {
                if (X[row - 1] == Y[col - 1]) {
                    dp[row][col] = 1 + dp[row - 1][col - 1];
                } else {
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
                }
            }
        }
        return dp[m][n];

    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;
        int lcs = lcs(X, Y, m, n);
        System.out.println("The Longest Common Subsequence is : " + lcs);
    }
}
