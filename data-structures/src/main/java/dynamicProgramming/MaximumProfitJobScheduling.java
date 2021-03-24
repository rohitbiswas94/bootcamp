package dynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumProfitJobScheduling {

    private static class Job {
        int start;
        int end;
        int profit;

        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int noOfJobs = startTime.length;
        Job[] jobs = new Job[noOfJobs];
        int dp[] = new int[noOfJobs];
        for (int i = 0; i < noOfJobs; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(job -> job.end));
        for (int i = 0; i < noOfJobs; i++) {
            dp[i] = jobs[i].profit;
        }
        int maxProfit = jobs[0].profit;
        for (int i = 1; i < noOfJobs; i++) {
            for (int j = 0; j < i; j++) {
                if (jobs[j].end <= jobs[i].start) {
                    dp[i] = Math.max(dp[j] + jobs[i].profit, dp[i]);
                }
                maxProfit = Math.max(maxProfit, dp[i]);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] startTime = {1, 2, 4, 6, 5, 7};
        int[] endTime = {3, 5, 6, 7, 8, 9};
        int[] profit = {5, 6, 5, 4, 11, 2};
        int maxProfit = jobScheduling(startTime, endTime, profit);
        System.out.println(maxProfit);
    }
}
