package datastructures;

public class GasStations {

    private static int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length != cost.length) return -1;
        int numOfStations = gas.length;
        int startPos = 0;
        int currPos = 0;
        int currBalance = 0;
        int totalBalance = 0; // If its > 0 then it means a circular tour is possible else return -1
        while (currPos < numOfStations) {
            totalBalance += gas[currPos] - cost[currPos];
            currBalance += gas[currPos] - cost[currPos];
            if (currBalance < 0) {
                startPos = currPos + 1;
                currBalance = 0;
            }
            currPos++;
        }
        if (totalBalance < 0) return -1;
        return startPos;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
