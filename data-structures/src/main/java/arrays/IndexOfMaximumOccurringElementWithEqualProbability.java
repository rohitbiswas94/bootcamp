package arrays;

import java.util.*;

public class IndexOfMaximumOccurringElementWithEqualProbability {

    private static int getRandomIndexOfMostOccurringElement(int[] arr) {
        if (arr.length == 0) return -1;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int maxOccurringElement = arr[0];
        int frequency = 1;
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                List<Integer> list = new LinkedList<>();
                list.add(i);
                map.put(arr[i], list);
            } else {
                List<Integer> list = map.get(arr[i]);
                list.add(i);
                map.put(arr[i], list);
                if (frequency < list.size()) {
                    maxOccurringElement = arr[i];
                    frequency = list.size();
                }
            }
        }
        return getRandomIndexOfMostOccurringElement(map, maxOccurringElement);
    }

    private static int getRandomIndexOfMostOccurringElement(Map<Integer, List<Integer>> map, int maxOccurringElement) {
        List<Integer> list = map.get(maxOccurringElement);
        Random r = new Random();
        return list.get(r.nextInt(list.size()));
    }

    public static void main(String[] args) {
        int[] arr = {-1, 4, 9, 7, 7, 2, 7, 3, 0, 9, 6, 5, 7, 8, 9};
        System.out.println(getRandomIndexOfMostOccurringElement(arr));
    }
}
