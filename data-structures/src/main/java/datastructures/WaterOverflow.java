/*
 Program to find amount of water in a given glass.
 You can put water to only top glass. If you put more than 1 litre water to 1st glass, water overflows and fills
 equally in both 2nd and 3rd glasses. Glass 5 will get water from both 2nd glass and 3rd glass and so on.
 If you have X litre of water and you put that water in top glass, how much water will be contained by jth glass in ith row
 */

package datastructures;

import java.util.Arrays;
import java.util.Scanner;

public class WaterOverflow {

    private static double calculateRemainingWater(int row, int col, double w) {
        double c = 1.0;
        double dp[][] = new double[row + 1][row + 1];
        for (double[] a : dp) {
            Arrays.fill(a, 0.0);
        }
        dp[0][0] = w;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] > c) {
                    w = dp[i][j] - c;
                    dp[i][j] = c;
                    dp[i + 1][j] += w / 2;
                    dp[i + 1][j + 1] += w / 2;
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for (int testCase = 1; testCase<=testCases;testCase++) {
            int water = in.nextInt();
            int row = in.nextInt();
            int col = in.nextInt();
            double waterRemaining = calculateRemainingWater(row, col, (double) water);
            System.out.println("Amount of water in row: " + row + " and column: " + col + " is = " + waterRemaining);
        }

    }
}
