package sorting;

public class QuickSort {

    private static int partition(int low, int high, int arr[]) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    public static void quickSort(int low, int high, int arr[]) {
        if (low < high) {
            int pivot = partition(low, high, arr);
            quickSort(low, pivot - 1, arr);
            quickSort(pivot + 1, high, arr);
        }
    }

    public static void main(String args[]) {
        int arr[] = {10, 16, 8, 12, 15, 6, 3, 9, 5};
        quickSort(0, arr.length - 1, arr);
        for (int itr : arr)
            System.out.println(itr);
    }

}
