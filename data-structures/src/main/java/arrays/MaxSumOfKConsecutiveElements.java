/* Slinding Window Technique */

package arrays;

public class MaxSumOfKConsecutiveElements {

    private static int maxSumOfKConsecutiveElements(int[] arr, int k) {
        int maxSum = 0;
        if (arr.length == 0) return 0;
        if (arr.length == 1) return arr[0];
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }
        int currentSum = maxSum;
        for (int i = k; i < arr.length; i++) {
            currentSum += arr[i] - arr[i - k];
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;
        int maxSum = maxSumOfKConsecutiveElements(arr, k);
        System.out.println(maxSum);
    }
}
