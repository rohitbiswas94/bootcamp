package dynamicProgramming;

public class LongestPalindromicSubsequence {

    private static int longestPalindromeSubseq(String s) {
        if (s.length() == 1) return 1;
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <= i + 1; j++) {
                if (i == j)
                    dp[i][j] = 1;
                else if (i + 1 == j && j < s.length()) {
                    if (s.charAt(i) == s.charAt(j))
                        dp[i][j] = 2;
                    else
                        dp[i][j] = 1;
                }
            }
        }
        for (int k = 2; k < s.length(); k++) {
            for (int i = 0, j = k; i < s.length() && j < s.length(); i++, j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
            }
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        String s = "AGBDBA";
        int lps = longestPalindromeSubseq(s);
        System.out.println(lps);
    }
}
