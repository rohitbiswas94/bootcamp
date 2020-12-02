package heap;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedArrays {

    private static class HeapNode {
        int val;
        int i;
        int j;

        HeapNode(int val, int i, int j) {
            this.val = val;
            this.i = i;
            this.j = j;
        }
    }

    private static int left(int i) {
        return 2 * i + 1;
    }

    private static int right(int i) {
        return 2 * i + 2;
    }

    private static void swap(HeapNode[] heap, int i, int j) {
        HeapNode val = heap[i];
        heap[i] = heap[j];
        heap[j] = val;
    }

    private static void buildHeap(HeapNode[] heap, int k) {
        for (int i = (k - 1) / 2; i >= 0; i--)
            heapify(heap, k, i);
    }

    private static ArrayList<Integer> mergeKArrays(int[][] arrays, int k) {
        int n = arrays[0].length;
        HeapNode[] heap = new HeapNode[k];
        int heap_size = k;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++)
            heap[i] = new HeapNode(arrays[i][0], i, 0);
        buildHeap(heap, k);
        while (heap_size != 0) {
            HeapNode node = heap[0];
            list.add(node.val);
            if (node.j + 1 < n) {
                int col = node.j + 1;
                int row = node.i;
                heap[0] = new HeapNode(arrays[row][col], row, col);
                heapify(heap, heap_size, 0);
            } else {
                heap[0] = heap[heap_size - 1];
                heap_size--;
                heapify(heap, heap_size, 0);
            }
        }
        return list;
    }

    private static void heapify(HeapNode[] heap, int heap_size, int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && heap[l].val < heap[smallest].val)
            smallest = l;
        if (r < heap_size && heap[r].val < heap[smallest].val)
            smallest = r;
        if (smallest != i) {
            swap(heap, i, smallest);
            heapify(heap, heap_size, smallest);
        }
    }

    public static void main(String[] args) {
        int[][] arrays = {
                {2, 6, 12, 34},
                {1, 9, 20, 1000},
                {23, 34, 90, 2000}
        };
        int k = 3;
        List<Integer> list = mergeKArrays(arrays, k);
        list.forEach(x -> System.out.print(x + " "));
    }
}
