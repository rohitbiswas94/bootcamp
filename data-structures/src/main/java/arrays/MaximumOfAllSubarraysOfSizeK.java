/*
    Given an array and an integer K, find the maximum for each and every contiguous subarray of size k.
    Maximum of all subarrays of size k.
*/

package arrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumOfAllSubarraysOfSizeK {

    private static void findMaximumOfSubArrays(int[] arr, int k) {

        Deque<Integer> dq = new ArrayDeque<>(k);
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && arr[i] > arr[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }
        for (int i = k; i < arr.length; i++) {
            System.out.println(arr[dq.peekFirst()]);
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && arr[i] > arr[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }
        System.out.println(arr[dq.peekFirst()]);
    }

    public static void main(String[] args) {
        int[] arr = {9, 7, 2, 4, 6, 8, 2, 1, 5};
        int k = 3;
        findMaximumOfSubArrays(arr, k);
    }
}
