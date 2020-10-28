/* Find length of longest subsequence of one string which is substring of another string */

package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class LongestSubsequenceSubstring {

    private static int longestSubsequenceSubstring(String x, String y, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, 0);
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (y.charAt(j - 1) == x.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int maxLength = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                maxLength = Math.max(dp[i][j], maxLength);
            }
        }
        for (int[] arr: dp) {
            System.out.println(Arrays.toString(arr));
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int m = in.nextInt();
            int n = in.nextInt();
            String x = in.next();
            String y = in.next();
            int maxLength = longestSubsequenceSubstring(x, y, m, n);
            System.out.println("Max length is : " + maxLength);
        }
    }
}
