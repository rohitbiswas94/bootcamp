package heap;

class BuildMaxHeapFromArray {

    private int leftChild(int i) {
        return (2 * i + 1);
    }

    private int rightChild(int i) {
        return (2 * i + 2);
    }

    private void swap(int i, int j, int[] arr) {
        int num = arr[i];
        arr[i] = arr[j];
        arr[j] = num;
    }

    private void buildHeap(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
    }

    private void printArray(int[] arr) {
        for (int x : arr)
            System.out.print(x + "\t");
    }

    private void heapify(int[] arr, int n, int i) {
        int l = leftChild(i);
        int r = rightChild(i);
        int largest = i;
        if (l < n && arr[l] > arr[largest])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
            swap(i, largest, arr);
            heapify(arr, n, largest);
        }
    }

    public static void main (String[] args) {
        int[] arr = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        BuildMaxHeapFromArray buildHeapObj = new BuildMaxHeapFromArray();
        buildHeapObj.buildHeap(arr);
        buildHeapObj.printArray(arr);
    }
}
