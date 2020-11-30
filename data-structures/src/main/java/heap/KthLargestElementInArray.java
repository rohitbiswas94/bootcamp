package heap;

public class KthLargestElementInArray {

    private static int left(int i) {
        return 2 * i + 1;
    }

    private static int right(int i) {
        return 2 * i + 2;
    }

    private static int parent(int i) {
        return (i - 1) / 2;
    }

    private static void swap(int[] heap, int i, int j) {
        int val = heap[i];
        heap[i] = heap[j];
        heap[j] = val;
    }

    private static void insert(int val, int[] heap, int heap_size) {
        heap[heap_size] = val;
        int i = heap_size;
        while (i > 0 && heap[i] < heap[parent(i)]) {
            swap(heap, i, parent(i));
            i = parent(i);
        }
    }

    private static void minHeapify(int[] heap, int heap_size, int i) {
        int left = left(i);
        int right = right(i);
        int smallest = i;
        if (left < heap_size && heap[left] < heap[smallest])
            smallest = left;
        if (right < heap_size && heap[right] < heap[smallest])
            smallest = right;
        if (smallest != i) {
            swap(heap, smallest, i);
            minHeapify(heap, heap_size, smallest);
        }
    }

    private static int findKthLargest(int[] nums, int k) {
        int[] heap = new int[k];
        int heap_size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (heap_size < k) {
                insert(nums[i], heap, heap_size);
                heap_size++;
            } else {
                if (nums[i] > heap[0]) {
                    heap[0] = nums[i];
                    minHeapify(heap, heap_size, 0);
                }
            }
        }
        return heap[0];
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4, 9, 7, 8};
        int k = 3;
        System.out.println(findKthLargest(nums, k));
    }
}
