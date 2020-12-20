package arrays;

public class RearrangeArrayAlternately {

    public static void rearrange(int arr[], int n) {
        int[] nums = new int[n];
        boolean flag = true;
        if (n == arr.length && arr.length > 1) {
            int i = 0, j = n - 1, c = 0;
            while (i < j) {
                if (arr[i] > arr[j]) {
                    flag = false;
                    break;
                }
                nums[c++] = arr[j];
                nums[c++] = arr[i];
                i++;
                j--;
            }
            if (i == j && i!=0)
                nums[c] = arr[i];
            for (i = 0; i < n && flag; i++) {
                arr[i] = nums[i];
            }
        }
        for (int x : arr)
            System.out.print(x + "\t");
    }

    public static void main(String[] args) {
        int[] arr = {1969, 2677, 3142, 4631, 4764, 5748, 6476, 6487};
        int n = 8;
        rearrange(arr, n);
    }
}
