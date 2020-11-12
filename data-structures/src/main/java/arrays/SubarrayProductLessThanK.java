package arrays;

public class SubarrayProductLessThanK {

    private static int subarrayProductLessThanK(int[] nums, int k) {
        int l = 0;
        int length = nums.length;
        int count = 0;
        int prod = 1;
        if (k <= 1) return 0;
        for (int r = 0; r < length; r++) {
            prod *= nums[r];
            while (prod >= k){
                prod /= nums[l];
                l++;
            }
            count += r - l + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 0;
        int numOfSubarrays = subarrayProductLessThanK(nums, k);
        System.out.println(numOfSubarrays);
    }
}
