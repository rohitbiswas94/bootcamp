package greedyAlgorithms;

public class MinimumPlatforms {

    private static int getMinPlatforms(int[] arrival, int[] departure) {
        int ai = 0;
        int di = 0;
        int minPlatforms = 0;
        int platforms = 0;
        while (ai < arrival.length && di < departure.length) {
            if (arrival[ai] < departure[di]) {
                platforms++;
                ai++;
            } else {
                platforms--;
                di++;
            }
            minPlatforms = Math.max(minPlatforms, platforms);
        }
        return minPlatforms;
    }

    public static void main(String[] args) {
        int[] arrival = {900, 940, 950, 1100, 1500, 1800};
        int[] departure = {910, 1200, 1120, 1130, 1900, 2000};
        int minPlatforms = getMinPlatforms(arrival, departure);
        System.out.println("The minimum number of platforms required : " + minPlatforms);
    }
}
