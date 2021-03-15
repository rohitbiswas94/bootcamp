package arrays;

public class MaximumLengthOfSubarrayWithPositiveProduct {

    public static int getMaxLen(int[] nums) {
        int negNos = 0;
        int maxLen = 0;
        int firstNeg = -1;
        int lastNeg = -1;
        int startIndexSubArray = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] < 0) {
                negNos++;
                if (firstNeg == -1) firstNeg = i;
                lastNeg = i;
            } else if (nums[i] == 0) {
                maxLen = Math.max(maxLen, solve(startIndexSubArray, i - 1, negNos, firstNeg, lastNeg));
                startIndexSubArray = i + 1;
                firstNeg = -1;
                lastNeg = -1;
                negNos = 0;
            }
        }
        maxLen = Math.max(maxLen, solve(startIndexSubArray, length - 1, negNos, firstNeg, lastNeg));
        return maxLen;
    }

    private static int solve(int l, int r, int negNos, int firstNeg, int lastNeg) {
        if (negNos % 2 == 0) {
            return r - l + 1;
        } else {
            return Math.max(lastNeg - l, r - firstNeg);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 0, -1, 6, 8, -2, -3, -4, 0, 4, 0};
        System.out.println(getMaxLen(nums));
    }
}
