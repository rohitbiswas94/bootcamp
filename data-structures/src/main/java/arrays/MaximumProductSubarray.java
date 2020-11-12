package arrays;

public class MaximumProductSubarray {

    private static int maximumProductSubarray(int[] nums) {
        int length = nums.length;
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int currentMax = nums[0];
        int prev_min = nums[0];
        for (int i = 1; i < length; i++) {
            min_so_far = Math.min(nums[i], Math.min(nums[i] * min_so_far, nums[i] * max_so_far));
            max_so_far = Math.max(nums[i], Math.max(nums[i] * max_so_far, nums[i] * prev_min));
            prev_min = min_so_far;
            currentMax = Math.max(currentMax, max_so_far);
        }
        return currentMax;
    }

    public static void main(String[] args) {
        int[] nums = {2,-5,-2,-4,3};
        int max = maximumProductSubarray(nums);
        System.out.println(max);
    }
}
