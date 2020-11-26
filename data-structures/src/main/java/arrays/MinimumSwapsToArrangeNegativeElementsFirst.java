package arrays;

public class MinimumSwapsToArrangeNegativeElementsFirst {

    private static int minSwaps(int[] nums, int n) {
        int i = 0;
        int j = n - 1;
        int swaps = 0;
        while (true) {
            while (nums[i] < 0 && i < j)
                i++;
            while (nums[j] > 0 && i < j)
                j--;
            if (i < j) {
                swaps++;
                swap(i, j, nums);
            } else
                break;
        }
        displayArray(nums);
        return swaps;
    }

    private static int[] swap(int i, int j, int[] nums) {
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
        return nums;

    }

    private static void displayArray(int[] nums) {
        for (int x : nums)
            System.out.print(x + "\t");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 2, 2, -1, 2, 2, 2, -1};
        System.out.println(minSwaps(nums, nums.length));
    }
}
