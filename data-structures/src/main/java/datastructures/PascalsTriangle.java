package datastructures;

import java.util.Arrays;

public class PascalsTriangle {

    private static void calculatePascalTriangle(int n) {
        int[][] dp = new int[n][n];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        for (int line = 0; line < n; line++) {
            for (int i = 0; i <= line; i++) {
                if (line == i || i == 0) {
                    dp[line][i] = 1;
                } else {
                    dp[line][i] = dp[line - 1][i - 1] + dp[line - 1][i];
                }
            }
        }
        printPascalTriangle(dp, n);
    }

    private static void printPascalTriangle(int[][] dp, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] != -1) {
                    System.out.print(dp[i][j]+ "\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 7;
        calculatePascalTriangle(n);
    }
}
