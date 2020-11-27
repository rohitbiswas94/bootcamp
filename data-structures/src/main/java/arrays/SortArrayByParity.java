/*
    Given an array A of non-negative integers, return an array consisting of all the even elements of A,
     followed by all the odd elements of A.
 */
package arrays;

public class SortArrayByParity {

    private static void sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 == 1) {
                int num = A[i];
                A[i] = A[j];
                A[j] = num;
                j--;
            } else {
                i++;
            }
        }
        for (int x : A)
            System.out.print(x + "\t");
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};
        sortArrayByParity(nums);
    }
}
