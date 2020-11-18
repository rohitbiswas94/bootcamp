/*
    This question uses the Longest Subarray with SumK logic.
    The minimum operations required to reduce X to 0 is basically the
    (ArrayLength - LongestSubArray with Sum (totalArraySum - X).
    Ex: nums[] = {1, 1, 4, 2, 3} and X = 5 so we can see that the totalArraySum = 11 and target = 11-X = 6,
    so the length of the longest subarray with sum = 6 is 3 (SubArray = [1,1,4]) .
    Hence the minimum operations is basically the length of the rest of the items whose summation is X. Thus Ans = 2 (5 - 3).
*/
package arrays;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationsToReduceXToZero {

    private static int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for (int num : nums)
            totalSum += num;
        if (totalSum < x)
            return -1;
        if (totalSum == x)
            return nums.length;
        int target = totalSum-x;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int currSum = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if (map.containsKey(currSum - target)) {
                maxLength = Math.max(maxLength, i - map.get(currSum - target) + 1);
            }
            map.put(currSum, i + 1);
        }
        return maxLength == 0 ? -1 : nums.length - maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 4, 2, 3};
        int x = 5;
        System.out.println(minOperations(nums, x));
    }
}
