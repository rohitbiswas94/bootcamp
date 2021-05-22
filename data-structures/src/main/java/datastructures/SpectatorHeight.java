package datastructures;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class SpectatorHeight {

    public static void main(String[] args) {
        int n =3;
        int m = 3;
        int[][] arr = {
                {2,1},
                {3,1},
                {3,2}
        };
        System.out.println(spec(n,m,arr));
    }

    public static int spec(int n, int m, int[][] arr) {
        Map<Integer, Integer> heightMap = new HashMap<>();
        for (int i=1; i<=m; i++) {
            heightMap.put(i, i);
        }
        List<Pair<Integer, Integer>> swapList = new ArrayList<>();
        for (int i =0;i<arr.length; i++) {
            swapList.add(new Pair<>(arr[i][0], arr[i][1]));
        }
        while (true) {
            AtomicBoolean found = new AtomicBoolean(false);
            swapList.forEach(pair -> {
                int x = pair.getKey();
                int y = pair.getValue();
                int xHeight = heightMap.get(x);
                int yHeight = heightMap.get(y);
                if (xHeight - yHeight == 1) {
                    found.set(true);
                    heightMap.put(x, xHeight-1);
                    heightMap.put(y, yHeight+1);
                }
            });
            if (!found.get()) {
                break;
            }
        }
        return (heightMap.get(1));
    }
}

