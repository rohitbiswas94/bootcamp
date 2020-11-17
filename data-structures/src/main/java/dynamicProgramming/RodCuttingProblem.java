package dynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RodCuttingProblem {

    private static void maxProfitRodCutting(int[] len, int[] val, int rodLength, int[][] dp) {

        if (rodLength == 0) System.out.println(0);
        for (int i = 0; i <= len.length; i++) {
            for (int j = 0; j <= rodLength; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (j < len[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i][j - len[i - 1]]);
                }
            }
        }
        System.out.println(dp[len.length][rodLength]);
    }

    private static void calcCuttingPoints(int[] len, int rodLength, int[][] dp) {
        List<Integer> cuttingPoints = new ArrayList<>();
        int i = len.length;
        int j = rodLength;
        while (i != 0 && j != 0) {
            if (dp[i][j] == dp[i - 1][j])
                i--;
            else {
                j -= len[i - 1];
                if (j != 0) cuttingPoints.add(j);
            }
        }
        Collections.reverse(cuttingPoints);
        System.out.println(cuttingPoints);
    }

    public static void main(String[] args) {
        int[] val = {1, 5, 8, 9, 10, 17, 17, 20};
        int[] len = {1, 2, 3, 4, 5 , 6, 7, 8};
        int rodLength = 8;
        int[][] dp = new int[len.length + 1][rodLength + 1];
        maxProfitRodCutting(len, val, rodLength, dp);
        calcCuttingPoints(len, rodLength, dp);
    }
}
