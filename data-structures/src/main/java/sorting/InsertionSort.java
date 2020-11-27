package sorting;

public class InsertionSort {

    private static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int key = nums[i];
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
        for (int x : nums)
            System.out.print(x + "\t");
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 10, 12, 1, 5, 6};
        sort(nums);
    }
}
