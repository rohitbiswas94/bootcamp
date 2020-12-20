package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpecialElementInMatrix {

    private static int countSpecialElements(List<List<Integer>> matrix) {
        if (matrix == null || matrix.size() == 0) return -1;
        int m = matrix.size();
        int n = matrix.get(0).size();
        int[][] arr = new int[m][n];
        for (int i=0; i<m; i++) {
            List<Integer> list = matrix.get(i);
            for (int j=0; j<n ; j++) {
                arr[i][j] = list.get(j);
            }
        }
        Set<Integer> positionalElements = new HashSet<>();
        for(int i=0; i<m; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j=0; j<n; j++) {
                if (min == arr[i][j]) return -1;
                min = Math.min(min, arr[i][j]);
                if (max == arr[i][j]) return -1;
                max = Math.max(max, arr[i][j]);
            }
            positionalElements.add(min);
            positionalElements.add(max);
        }
        for(int j=0; j<n; j++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i=0; i<m; i++) {
                if (min == arr[i][j]) return -1;
                min = Math.min(min, arr[i][j]);
                if (max == arr[i][j]) return -1;
                max = Math.max(max, arr[i][j]);
            }
            positionalElements.add(min);
            positionalElements.add(max);
        }
        return positionalElements.size();
    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Stream.of(1, 3, 4).collect(Collectors.toList()));
        matrix.add(Stream.of(5, 2, 9).collect(Collectors.toList()));
        matrix.add(Stream.of(8, 7, 6).collect(Collectors.toList()));
        System.out.println(countSpecialElements(matrix));
    }
}
