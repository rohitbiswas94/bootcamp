package arrays;

public class TrappingRainWater {

    private static int totalWaterTrapped(int[] blocks, int length) {
        int[] left = new int[length];
        left[0] = blocks[0];
        for (int index = 1; index < length - 1; index++) {
            left[index] = Math.max(left[index - 1], blocks[index]);
        }
        int[] right = new int[length];
        right[length - 1] = blocks[length - 1];
        for (int index = length - 2; index > 0; index--) {
            right[index] = Math.max(right[index + 1], blocks[index]);
        }
        int totalWater = 0;
        for (int index = 1; index < length - 1; index++) {
            totalWater += Math.min(left[index], right[index]) - blocks[index];
        }
        return totalWater;
    }

    public static void main(String[] args) {
        int[] blocks = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int totalWater = totalWaterTrapped(blocks, blocks.length);
        System.out.println("Maximum water that can be accumulated is : " + totalWater);
    }
}
