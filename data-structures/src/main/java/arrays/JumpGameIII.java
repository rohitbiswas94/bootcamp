/*
    Given an array of non-negative integers arr, you are initially positioned at start index of the array.
    When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
    Notice that you can not jump outside of the array at any time.
 */
package arrays;

public class JumpGameIII {

    private static boolean canReach(int[] arr, int start) {
        boolean[] vis = new boolean[arr.length];
        return reach(arr, start, vis);
    }

    private static boolean reach(int[] arr, int start, boolean[] vis) {
        if (start < arr.length && start >= 0 && !vis[start]) {
            vis[start] = true;
            if (arr[start] == 0)
                return true;
            return reach(arr, start + arr[start], vis) || reach(arr, start - arr[start], vis);
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {4,2,3,0,3,1,2};
        int start = 5;
        System.out.println(canReach(arr, start));
    }
}
