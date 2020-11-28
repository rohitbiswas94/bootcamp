package heap;

public class MinHeap {

    private int capacity;
    private int[] heap;
    private int heap_size;

    private MinHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        heap_size = 0;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return (2 * i + 1);
    }

    private int rightChild(int i) {
        return (2 * i + 2);
    }

    private void swap(int i, int j) {
        int num = heap[i];
        heap[i] = heap[j];
        heap[j] = num;
    }

    private int getMin() {
        return heap[0];
    }

    private void insert(int value) {
        if (heap_size == capacity) {
            System.out.println("Overflow");
        } else {
            heap_size++;
            int i = heap_size - 1;
            heap[i] = value;
            while (i >= 0 && heap[i] < heap[parent(i)]) {
                swap(i, parent(i));
                i = parent(i);
            }
        }
    }

    private void decreaseKey(int i, int new_value) {
        if (new_value > heap[i]) {
            System.out.println("New value cannot be greater than key value");
        } else {
            heap[i] = new_value;
            while (i >= 0 && heap[i] < heap[parent(i)]) {
                swap(i, parent(i));
                i = parent(i);
            }
        }
    }

    private int extractMin() {
        if (heap_size == 0)
            System.out.println("Heap is Empty");
        if (heap_size == 1) {
            heap_size--;
            return heap[0];
        }
        int root = heap[0];
        heap[0] = heap[heap_size - 1];
        heap_size--;
        minHeapify(0);
        return root;
    }

    private void deleteKey(int i) {
        if (i < 0 || i >= heap_size) {
            System.out.println("Underflow");
        } else {
            decreaseKey(i, Integer.MIN_VALUE);
            extractMin();
        }
    }

    private void minHeapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;
        if (left < heap_size && heap[left] < heap[smallest])
            smallest = left;
        if (right < heap_size && heap[right] < heap[smallest])
            smallest = right;
        if (smallest != i) {
            swap(smallest, i);
            minHeapify(smallest);
        }
    }


    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.deleteKey(1);
        minHeap.insert(15);
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(45);
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.getMin());
        minHeap.decreaseKey(2, 1);
        System.out.println(minHeap.getMin());
    }
}
