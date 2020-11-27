package arrays;

public class CountInversionsInArray {

    private static int countInversions(int[] nums) {
        return partition(nums, 0, nums.length - 1);
    }

    private static int partition(int[] nums, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            count += partition(nums, low, mid);
            count += partition(nums, mid + 1, high);
            count += merge(nums, low, mid, high);
        }
        return count;
    }

    private static int merge(int[] nums, int low, int mid, int high) {
        int count = 0;
        int i = low;
        int j = mid + 1;
        int[] arr = new int[high - low + 1];
        int k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                arr[k++] = nums[i++];
            } else {
                arr[k++] = nums[j++];
                count += mid - i + 1;
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
        return count;
    }

    private static void display(int[] nums) {
        for (int x : nums)
            System.out.print(x + "\t");
    }

    public static void main(String[] args) {
        int[] nums = {9, 6, 8, 4};
        int countOfInversions = countInversions(nums);
        System.out.println(countOfInversions);
        display(nums);

    }
}
