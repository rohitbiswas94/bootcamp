package arrays;

public class BestTimeToBuySellStockAtmost2Transactions {

    private static int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int[] firstProfit = new int[prices.length];
        int[] secondProfit = new int[prices.length];
        int min_buy = prices[0];
        int max_sell = prices[prices.length - 1];
        int profit = 0;
        firstProfit[0] = 0;
        secondProfit[prices.length - 1] = 0;
        for (int i = 1; i < prices.length; i++) {
            min_buy = Math.min(min_buy, prices[i]);
            firstProfit[i] = Math.max(firstProfit[i - 1], prices[i] - min_buy);
        }
        for (int i = prices.length - 2; i >= 0; i--) {
            max_sell = Math.max(max_sell, prices[i]);
            secondProfit[i] = Math.max(secondProfit[i + 1], max_sell - prices[i]);
        }
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, firstProfit[i] + secondProfit[i]);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }
}
