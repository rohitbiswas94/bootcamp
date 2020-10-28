package arrays;

public class TrappingRainWater {

    private static int totalWaterTrapped(int[] blocks) {
        if (blocks.length != 0) {
            int n = blocks.length;
            int[] left = new int[n];
            left[0] = blocks[0];
            for (int i = 1; i < n; i++) {
                left[i] = Math.max(left[i - 1], blocks[i]);
            }
            int[] right = new int[n];
            right[n - 1] = blocks[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                right[i] = Math.max(right[i + 1], blocks[i]);
            }
            int water = 0;
            for (int i = 0; i < n; i++) {
                water += Math.min(left[i], right[i]) - blocks[i];
            }
            return water;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] blocks = {2, 0 ,2};
        int totalWater = totalWaterTrapped(blocks);
        System.out.println("Maximum water that can be accumulated is : " + totalWater);
    }
}
