package arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {

    private static int longestSubArrayWithSumK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int currSum = 0;
        int maxLength = -1;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if (map.containsKey(currSum - k)) {
                maxLength = Math.max(maxLength, i - map.get(currSum - k) + 1);
            }
            map.put(currSum, i + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 7, 1, 9};
        int k = 15;
        System.out.println(longestSubArrayWithSumK(nums, k));
    }
}
