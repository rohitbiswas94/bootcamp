package arrays;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegIntegerInWindowK {

    private static void negativeIntegers(int[] nums, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (nums[i] < 0)
                queue.add(i);
        }
        for (int i = k; i < nums.length; i++) {
            if (!queue.isEmpty()) {
                System.out.println(nums[queue.peek()]);
            } else {
                System.out.println(0);
            }
            while (!queue.isEmpty() && queue.peek() <= i - k)
                queue.remove();
            if (nums[i] < 0)
                queue.add(i);
        }
        if (!queue.isEmpty())
            System.out.println(nums[queue.peek()]);
        else
            System.out.println(0);
    }

    public static void main(String[] args) {
        int[] nums = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        negativeIntegers(nums, k);
    }
}
