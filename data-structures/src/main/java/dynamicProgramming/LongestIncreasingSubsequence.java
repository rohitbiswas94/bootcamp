package dynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    private static int lis(int[] arr) {
        if (arr.length != 0) {
            int[] dp = new int[arr.length];
            Arrays.fill(dp, 1);
            int maxLength = 1;
            for (int i = 1; i < arr.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        maxLength = Math.max(dp[i], maxLength);
                    }
                }
            }
            return maxLength;
        } else {
            return 0;
        }
    }


    public static void main(String args[]) {
        int[] arr = {10, 22, 1, 5, 7, 9, 11, 3, 25, 4};
        int lis = lis(arr);
        System.out.println("The longest increasing subsequence : " + lis);
    }
}
