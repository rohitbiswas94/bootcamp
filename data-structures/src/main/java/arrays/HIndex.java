package arrays;

import java.util.Arrays;

public class HIndex {
    private static int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        Arrays.sort(citations);
        int hIndex = 0, l = 0, h = citations.length - 1;
        int length = citations.length;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (citations[mid] >= length - mid) {
                hIndex = Math.max(hIndex, length - mid);
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return hIndex;
    }

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(hIndex(citations));
    }

}
