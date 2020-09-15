package dynamicProgramming;

public class LongestIncreasingSubsequence {

    private static int lis(int[] arr, int length) {
        int[] dp = new int[length];
        int longestSub = 0;
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
            int x = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] > arr[x]) {
                    dp[j] = dp[x] + 1;
                    x = j;
                }
            }
            longestSub = Math.max(longestSub, dp[x]);
        }
        return longestSub;
    }


    public static void main(String args[]) {
        int[] arr = {10, 22, 1, 5, 7, 9, 11, 3, 25, 4};
        int lis = lis(arr, arr.length);
        System.out.println("The longest increasing subsequence : " + lis);
    }
}
