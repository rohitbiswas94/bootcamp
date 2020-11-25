package arrays;

public class JumpGame {

    private static boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        if (nums[0] == 0) return false;
        int reachable = 0;
        for (int i = 0; i < nums.length && i <= reachable; i++) {
            reachable = Math.max(reachable, i + nums[i]);
            if (reachable >= nums.length - 1)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0};
        System.out.println(canJump(nums));
    }
}
