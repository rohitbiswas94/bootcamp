package dynamicProgramming;

public class GoldCoinProblem {

    private static int goldCoin(int[][] gold, int rows, int cols) {
        int[][] dp = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            dp[row][0] = gold[row][0];
        }
        int maxGold = Integer.MIN_VALUE;
        for (int col = 1; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                if (row - 1 >= 0 && row + 1 < rows) {
                    dp[row][col] = gold[row][col] +
                            Math.max((Math.max(dp[row - 1][col - 1], dp[row + 1][col - 1])), dp[row][col - 1]);
                } else if (row - 1 < 0 && row + 1 < rows) {
                    dp[row][col] = gold[row][col] + Math.max(dp[row][col - 1], dp[row + 1][col - 1]);
                } else {
                    dp[row][col] = gold[row][col] + Math.max(dp[row][col - 1], dp[row - 1][col - 1]);
                }
                maxGold = Math.max(dp[row][col], maxGold);
            }
        }
        return maxGold;
    }

    public static void main(String args[]) {
        int[][] gold = {{10, 33, 13, 15}, {22, 21, 4, 1}, {5, 0, 2, 3}, {0, 6, 14, 2}};
        int maxGold = goldCoin(gold, gold.length, gold[0].length);
        System.out.println("The maximum amount of gold is : " + maxGold);
    }
}
