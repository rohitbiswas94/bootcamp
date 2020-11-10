package arrays;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {

    private static int subArraysWithAtmostKDistinct(int[] arr, int K) {
        if (arr.length == 1) return 1;
        int left = 0;
        int right = 0;
        int maxSubArrays = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < arr.length) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            while (map.size() > K) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }
            maxSubArrays += right - left + 1;
            right++;
        }
        return maxSubArrays;
    }

    private static int subArraysWithExactlyKDistinct(int[] arr, int K) {
        return subArraysWithAtmostKDistinct(arr, K) -
                subArraysWithAtmostKDistinct(arr, K - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(subArraysWithExactlyKDistinct(arr, k));
    }
}
