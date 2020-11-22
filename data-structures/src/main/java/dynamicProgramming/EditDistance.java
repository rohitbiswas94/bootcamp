package dynamicProgramming;

public class EditDistance {

    private static int minDistance(String word1, String word2) {
        if ((word1 == null || word1.length() == 0) && (word2 == null || word2.length() == 0)) return 0;
        if (word1 == null || word1.length() == 0) return word2.length();
        if (word2 == null || word2.length() == 0) return word1.length();
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i=0; i<= m; i++) {
            for (int j=0; j<=n; j++) {
                if (i==0)
                    dp[i][j] = j;
                else if (j==0)
                    dp[i][j] = i;
                else {
                    if (word1.charAt(i-1) == word2.charAt(j-1))
                        dp[i][j] = dp[i-1][j-1];
                    else
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "sunday";
        String word2 = "saturday";
        System.out.println(minDistance(word1, word2));
    }
}
