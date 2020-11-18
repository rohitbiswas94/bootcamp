//Using DP
package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationsToReduceXToZeroDP {

    private static int minOperations(int[] nums, int x) {
        Map<String, Integer> map = new HashMap<>();
        int steps = findMinOperations(nums, x, 0, nums.length - 1, 0, map);
        return (steps == Integer.MAX_VALUE) ? -1 : steps;
    }

    private static int findMinOperations(int[] nums,
                                         int x,
                                         int left,
                                         int right,
                                         int steps,
                                         Map<String, Integer> map) {
        if (x == 0)
            return steps;
        if (x < 0 || left > right)
            return Integer.MAX_VALUE;
        String key = left + "*" + right + "*" + x;
        if (map.containsKey(key))
            return map.get(key);
        int leftSteps = findMinOperations(nums, x - nums[left], left + 1, right, steps + 1, map);
        int rightSteps = findMinOperations(nums, x - nums[right], left, right - 1, steps + 1, map);
        map.put(key, Math.min(leftSteps, rightSteps));
        return map.get(key);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 4, 2, 3};
        int x = 5;
        System.out.println(minOperations(nums, x));
    }
}
