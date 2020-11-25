/*
    Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
    Each element in the array represents your maximum jump length at that position.
    Your goal is to reach the last index in the minimum number of jumps.
 */
package dynamicProgramming;

import java.util.Arrays;

public class JumpGameII {

    private static int jump(int[] nums) {
        if (nums.length == 1 || nums[0] == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i=0 ; i<nums.length-1; i++) {
            for (int j=i+1; nums[i] + i >= j && j<nums.length; j++) {
                if (nums[i] != 0) {
                    dp[j] = Math.min(dp[j], dp[i] + 1);
                }
            }
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,2,4,2,0,1,1};
        System.out.println(jump(nums));
    }
}
