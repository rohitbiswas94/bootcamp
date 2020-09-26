/*
    Count all the possible paths from top left to bottom right of a mXn matrix
    with the constraints that from each cell you can either move only to right or down
 */

package dynamicProgramming;

public class AllPossiblePathMatrix {

    private static int allPossibleWaysInMatrix(int row, int col) {
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++)
            dp[i][0] = 1;
        for (int j = 0; j < col; j++)
            dp[0][j] = 1;
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int row = 4, col = 4;
        int maxPaths = allPossibleWaysInMatrix(row, col);
        System.out.println("The maximum possible paths is : " + maxPaths);
    }


}
