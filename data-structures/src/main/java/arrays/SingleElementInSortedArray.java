package arrays;

public class SingleElementInSortedArray {

    public static int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length % 2 == 0) return -1;
        return findNonDuplicate(0, nums.length - 1, nums);
    }

    private static int findNonDuplicate(int l, int h, int[] nums) {
        int mid = l + (h - l) / 2;
        if (mid == 0 && nums[mid] != nums[mid + 1]) return nums[mid];
        else if (mid == nums.length - 1 && nums[mid] != nums[mid - 1]) return nums[mid];
        else if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) return nums[mid];
        else {
            if (mid % 2 != 0) {
                if (nums[mid - 1] == nums[mid]) return findNonDuplicate(mid + 1, h, nums);
                else return findNonDuplicate(l, mid, nums);
            } else {
                if (nums[mid - 1] == nums[mid]) return findNonDuplicate(l, mid, nums);
                else return findNonDuplicate(mid + 1, h, nums);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(nums));
    }
}
