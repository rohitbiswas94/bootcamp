package arrays;

public class Merge2SortedArraysWithoutExtraSpace {

    private static void sort(int[] arr1, int[] arr2, int m, int n) {
        for (int i = n - 1; i >= 0; i--) {
            int last = arr1[m-1];
            int j = m - 2;
            while (j >= 0 && arr1[j] > arr2[i]) {
                arr1[j + 1] = arr1[j];
                --j;
            }
            if (j != m - 2 || last > arr2[i]) {
                arr1[j+1] = arr2[i];
                arr2[i] = last;
            }
        }
        display(arr1);
        display(arr2);
    }

    private static void display(int[] arr) {
        for (int x : arr)
            System.out.print(x + "\t");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {0, 2, 6, 8, 9};
        sort(arr1, arr2, arr1.length, arr2.length);
    }
}
