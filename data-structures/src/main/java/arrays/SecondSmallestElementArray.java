package arrays;

public class SecondSmallestElementArray {

    private static int secondSmallest(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int i = 0; i<nums.length; i++) {
            if (nums[i] < min) {
                secondMin = min;
                min = nums[i];
            } else if (nums[i] < secondMin && nums[i] != min) {
                secondMin = nums[i];
            }
        }
        if (secondMin == Integer.MAX_VALUE) return -1;
        return secondMin;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,8,2,3,9};
        System.out.println(secondSmallest(nums));
    }
}
