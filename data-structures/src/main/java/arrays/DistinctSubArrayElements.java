package arrays;

import java.util.List;
import java.util.ArrayList;

public class DistinctSubArrayElements
{
    public static void queryDistinct(final int query, final int[][] qarr, final int[] arr) {
        for (int i = 0; i < query; ++i) {
            findDistinct(arr, qarr[i][0], qarr[i][1]);
        }
    }

    public static void findDistinct(final int[] arr, final int l, final int r) {
        final List<Integer> list = new ArrayList<Integer>();
        for (int i = l; i <= r; ++i) {
            if (!list.contains(arr[i])) {
                list.add(arr[i]);
            }
        }
        System.out.println(list.size());
    }

    public static void main(final String[] args) {
        final int query = 3;
        final int[][] qarr = { { 0, 4 }, { 1, 3 }, { 2, 4 } };
        final int[] arr = { 1, 1, 2, 1, 3 };
        queryDistinct(query, qarr, arr);
    }
}