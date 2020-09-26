/*
    Program to find the longest path in a matrix given that the difference between the cells is 1
 */
package dynamicProgramming;

import java.util.Arrays;

public class LongestPathMatrix {

    private static int calculateLongestPathEachCell(int i, int j, int length, int[][] arr, int[][] dp) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        } else {
            if (i - 1 >= 0 && arr[i][j] + 1 == arr[i - 1][j]) {
                dp[i][j] = 1 + calculateLongestPathEachCell(i - 1, j, length, arr, dp);
            }
            if (i + 1 < length && arr[i][j] + 1 == arr[i + 1][j]) {
                dp[i][j] = 1 + calculateLongestPathEachCell(i + 1, j, length, arr, dp);
            }
            if (j - 1 >= 0 && arr[i][j] + 1 == arr[i][j - 1]) {
                dp[i][j] = 1 + calculateLongestPathEachCell(i, j - 1, length, arr, dp);
            }
            if (j + 1 < length && arr[i][j] + 1 == arr[i][j + 1]) {
                dp[i][j] = 1 + calculateLongestPathEachCell(i, j + 1, length, arr, dp);
            }
            return dp[i][j] = Math.max(dp[i][j], 1);
        }
    }

    private static int findLongestPath(int[][] arr) {
        int maxLength = 0;
        int length = arr.length;
        int[][] dp = new int[arr.length][arr.length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int currentLength = calculateLongestPathEachCell(i, j, length, arr, dp);
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 9},
                {5, 3, 8},
                {4, 6, 7}};
        System.out.println("Length of the longest path is " + findLongestPath(arr));
    }
}
