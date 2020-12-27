package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class DifferenceBetween2Arrays {

    private static void difference(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        IntStream.range(0, arr1.length).forEach(i -> map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1));
        IntStream.range(0, arr2.length).forEach(i -> {
            if (map.containsKey(arr2[i])) {
                map.put(arr2[i], map.get(arr2[i]) - 1);
            }
        });
        map.forEach((key, value) -> {
            if (value > 0) list.add(key);
        });
        list.forEach(x -> System.out.print(x + "\t"));
    }

    public static void main(String[] args) {
        int[] arr1 = {3,5,2,7,4,2,7};
        int[] arr2 = {1,7,5,2,2,9};
        difference(arr1, arr2);
        System.out.println();
        difference(arr2, arr1);
    }
}
