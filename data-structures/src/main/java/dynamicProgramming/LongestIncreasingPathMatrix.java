package dynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingPathMatrix {

    private static int longestIncreasingPathEachCell(int[][] arr, int i, int j, int[][] dp) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        } else {
            int m = arr.length;
            int n = arr[0].length;
            int left = 0;
            int right = 0;
            int top = 0;
            int bottom = 0;
            if (j + 1 < n && arr[i][j] < arr[i][j + 1]) {
                right = 1 + longestIncreasingPathEachCell(arr, i, j + 1, dp);
            }
            if (i - 1 >= 0 && arr[i][j] < arr[i - 1][j]) {
                top = 1 + longestIncreasingPathEachCell(arr, i - 1, j, dp);
            }
            if (j - 1 >= 0 && arr[i][j] < arr[i][j - 1]) {
                left = 1 + longestIncreasingPathEachCell(arr, i, j - 1, dp);
            }
            if (i + 1 < m && arr[i][j] < arr[i + 1][j]) {
                bottom = 1 + longestIncreasingPathEachCell(arr, i + 1, j, dp);
            }
            return dp[i][j] = Math.max(Math.max(Math.max(Math.max(1, left), right), top), bottom);
        }
    }

    private static int longestIncreasingPath(int[][] arr, int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        int longestPath = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int longestPathCurrentCell = longestIncreasingPathEachCell(arr, i, j, dp);
                longestPath = Math.max(longestPath, longestPathCurrentCell);
            }
        }
        return longestPath;
    }

    public static void main(String[] args) {
        int[][] arr = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        int longestPath = longestIncreasingPath(arr, arr.length, arr[0].length);
        System.out.println("Length of the longest increasing path in the matrix is : " + longestPath);
    }
}
