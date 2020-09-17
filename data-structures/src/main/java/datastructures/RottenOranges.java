package datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    static class Coordinates {
        int x;
        int y;

        Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int rottenOranges(int[][] arr) {
        Queue<Coordinates> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 2) {
                    queue.add(new Coordinates(i, j));
                }
            }
        }
        queue.add(new Coordinates(-1, -1));
        int timeFrame = -1;
        while (!queue.isEmpty()) {
            Coordinates coordinates = queue.peek();
            int i = coordinates.x;
            int j = coordinates.y;
            if (i == -1 && j == -1) {
                timeFrame++;
                queue.remove();
                if (!queue.isEmpty()) {
                    queue.add(new Coordinates(-1, -1));
                }
            } else {
                if (i - 1 >= 0) {
                    if (arr[i - 1][j] == 1) {
                        queue.add(new Coordinates(i - 1, j));
                        arr[i - 1][j] = 2;
                    }
                }
                if (i + 1 < arr.length) {
                    if (arr[i + 1][j] == 1) {
                        queue.add(new Coordinates(i + 1, j));
                        arr[i + 1][j] = 2;
                    }
                }
                if (j - 1 >= 0) {
                    if (arr[i][j - 1] == 1) {
                        queue.add(new Coordinates(i, j - 1));
                        arr[i][j - 1] = 2;
                    }
                }
                if (j + 1 < arr[0].length) {
                    if (arr[i][j + 1] == 1) {
                        queue.add(new Coordinates(i, j + 1));
                        arr[i][j + 1] = 2;
                    }
                }
                queue.remove();
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    return -1;
                }
            }
        }
        return timeFrame;
    }

    public static void main(String[] args) {
        int arr[][] = {
                {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {0, 0, 0, 2, 1}
        };
        int timeFrame = rottenOranges(arr);
        if (timeFrame == -1)
            System.out.println("All oranges cannot rot");
        else
            System.out.println("Time required for all oranges to rot = " + timeFrame);
    }
}
