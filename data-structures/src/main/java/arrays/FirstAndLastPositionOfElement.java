//Find First and Last Position of Element in Sorted Array in O(Logn)
package arrays;

public class FirstAndLastPositionOfElement {

    public static int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int[] pos = new int[2];
        int l = 0;
        int h = length - 1;
        pos[0] = firstPositionOfElement(nums, l, h, target);
        pos[1] = lastPositionOfElement(nums, l, h, target);
        return pos;
    }

    private static int firstPositionOfElement(int[] nums, int l, int h, int t) {
        int position = -1;
        while (h >= l) {
            int mid = (l + h) / 2;
            if (nums[mid] == t) {
                position = mid;
            }
            if (nums[mid] >= t) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return position;
    }

    private static int lastPositionOfElement(int[] nums, int l, int h, int t) {
        int position = -1;
        while (h >= l) {
            int mid = (l + h) / 2;
            if (nums[mid] == t) {
                position = mid;
            }
            if (nums[mid] <= t) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return position;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] pos = searchRange(nums, target);
        for (int x : pos) System.out.print(x + "\t");
    }
}
