package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended {

    private static int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int day = 1, i = 0, eventsAttended = 0;
        while (!priorityQueue.isEmpty() || i < events.length) {
            while (i < events.length && day == events[i][0])
                priorityQueue.add(events[i++][1]);
            while (!priorityQueue.isEmpty() && priorityQueue.peek() < day)
                priorityQueue.poll();
            if (!priorityQueue.isEmpty()) {
                priorityQueue.poll();
                eventsAttended++;
            }
            day++;
        }
        return eventsAttended;
    }

    public static void main(String[] args) {
        int[][] events = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 2}
        };
        System.out.println(maxEvents(events));
    }
}
