/* Kadane's Algorithm */
package arrays;

public class LargestSumContiguousSubarray {

    private static int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;
        for (int i=0; i<nums.length; i++) {
            max_ending_here += nums[i];
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
            }
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
        }
        return max_so_far;
    }

    public static void main(String[] args) {
        int[] nums = {-2, -1};
        int max = maxSubArray(nums);
        System.out.println(max);
    }
}
