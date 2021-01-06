package heap;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class SortNearlySortedArray {

    private static void sortArray(int[] nums, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k + 1; i++) {
            pq.add(nums[i]);
        }
        int index = 0;
        for (int i = k + 1; i < nums.length && !pq.isEmpty(); i++) {
            nums[index++] = pq.poll();
            pq.add(nums[i]);
        }
        final Iterator<Integer> iterator = pq.iterator();
        while (iterator.hasNext() && !pq.isEmpty()) {
            nums[index++] = pq.poll();
        }
        IntStream.range(0, nums.length).forEach(i -> System.out.print(nums[i] + "\t"));
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 8, 7, 4, 70, 60, 50};
        int k = 4;
        sortArray(nums, k);
    }
}
