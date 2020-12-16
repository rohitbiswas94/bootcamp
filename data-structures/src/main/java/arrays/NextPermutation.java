/*
    Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 */
package arrays;

class NextPermutation {

    private static void nextPermutation(int[] nums) {
        if (nums.length == 1) return;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
        display(nums);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private static void display(int[] nums) {
        for (int x : nums)
            System.out.print(x + "\t");
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,2};
        nextPermutation(nums);

    }
}
