package sorting;

public class QuickSort {

    private static int partition(int low, int high, int arr[]) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                swap(i, j, arr);
                i++;
            }
        }
        if (i < high) {
            swap(i, high, arr);
        }
        return i;
    }

    private static void swap(int i, int j, int[] arr) {
        int num = arr[i];
        arr[i] = arr[j];
        arr[j] = num;
    }

    private static void quickSort(int low, int high, int arr[]) {
        if (low < high) {
            int pivot = partition(low, high, arr);
            quickSort(low, pivot - 1, arr);
            quickSort(pivot + 1, high, arr);
        }
    }

    public static void main(String args[]) {
        int arr[] = {8, 6, 9, 5, 10, 7, 11};
        quickSort(0, arr.length - 1, arr);
        for (int itr : arr)
            System.out.print(itr + "\t");
    }

}
