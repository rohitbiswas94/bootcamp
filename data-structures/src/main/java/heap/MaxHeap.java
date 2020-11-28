package heap;

public class MaxHeap {

    private int capacity;
    private int[] heap;
    private int heap_size;

    private MaxHeap(int capacity) {
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

    private int getMax() {
        return heap[0];
    }

    private void insert(int value) {
        if (heap_size == capacity) {
            System.out.println("Overflow");
        } else {
            heap_size++;
            int i = heap_size - 1;
            heap[i] = value;
            while (i >= 0 && heap[i] > heap[parent(i)]) {
                swap(i, parent(i));
                i = parent(i);
            }
        }
    }

    private void increaseKey(int i, int new_value) {
        if (new_value < heap[i]) {
            System.out.println("New value cannot be less than key value");
        } else {
            heap[i] = new_value;
            while (i >= 0 && heap[i] > heap[parent(i)]) {
                swap(i, parent(i));
                i = parent(i);
            }
        }
    }

    private int extractMax() {
        if (heap_size == 0)
            System.out.println("Heap is Empty");
        if (heap_size == 1) {
            heap_size--;
            return heap[0];
        }
        int root = heap[0];
        heap[0] = heap[heap_size - 1];
        heap_size--;
        maxHeapify(0);
        return root;
    }

    private void deleteKey(int i) {
        if (i < 0 || i >= heap_size) {
            System.out.println("Underflow");
        } else {
            increaseKey(i, Integer.MAX_VALUE);
            extractMax();
        }
    }

    private void maxHeapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;
        if (left < heap_size && heap[left] > heap[largest])
            largest = left;
        if (right < heap_size && heap[right] > heap[largest])
            largest = right;
        if (largest != i) {
            swap(largest, i);
            maxHeapify(largest);
        }
    }

    private void print() {
        for (int i = 0; i < heap_size / 2; i++) {
            System.out.print("Parent : " + heap[i] + " Left Child : " +
                    heap[2 * i + 1] + " Right Child :" + heap[2 * i + 2]);
            System.out.println();
        }
    }


    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        maxHeap.print();
        System.out.println("The max val is " + maxHeap.extractMax());
        maxHeap.increaseKey(8, 20);
        maxHeap.deleteKey(3);
        System.out.println("The max val is " + maxHeap.getMax());
        maxHeap.print();
    }
}
