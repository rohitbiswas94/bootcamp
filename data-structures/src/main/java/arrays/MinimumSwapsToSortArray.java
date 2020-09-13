package arrays;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumSwapsToSortArray {

    private static void minSwaps(int[] arr) {
        final ArrayList<Pair<Integer, Integer>> sortedArray = new ArrayList<>();
        for (int index = 0; index < arr.length; index++) {
            sortedArray.add(new Pair<>(arr[index], index));
        }
        sortedArray.sort((element1, element2) -> {
            if (element1.getKey() < element2.getKey())
                return -1;
            else if (element1.getKey() > element2.getKey())
                return 1;
            else
                return 0;
        });
        int swaps = 0;
        boolean vis[] = new boolean[arr.length];
        Arrays.fill(vis, false);
        for (int index = 0; index < sortedArray.size(); index++) {
            if (vis[index] || index == sortedArray.get(index).getValue()) {
                continue;
            }
            int nodesInCycle = 0;
            int pos = index;
            while (!vis[pos]) {
                vis[pos] = true;
                pos = sortedArray.get(pos).getValue();
                nodesInCycle++;
            }
            if (nodesInCycle > 0) {
                swaps += nodesInCycle - 1;
            }
        }
        System.out.println("The number of swaps required is : " + swaps);
    }

    public static void main(String[] args) {
        int[] arr = {8, 6, 9, 5, 10, 7, 11};
        minSwaps(arr);
    }
}
