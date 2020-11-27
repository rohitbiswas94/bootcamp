package sorting;

public class MergeSort {

    private static void partition(int[] nums, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            partition(nums, low, mid);
            partition(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int[] arr = new int[high - low + 1];
        int k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                arr[k++] = nums[i++];
            } else {
                arr[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            arr[k++] = nums[i++];
        }
        while (j <= high) {
            arr[k++] = nums[j++];
        }
        for (int x = low; x <= high; x++) {
            nums[x] = arr[x - low];
        }
    }

    private static void display(int[] nums) {
        for (int x : nums)
            System.out.print(x + "\t");
    }

    public static void main(String[] args) {
        int[] nums = {9, 6, 8, 4};
        partition(nums, 0, nums.length - 1);
        display(nums);

    }
}
