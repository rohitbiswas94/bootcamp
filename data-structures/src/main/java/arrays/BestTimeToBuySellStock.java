package arrays;

public class BestTimeToBuySellStock {

    private static int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int i = 0;
        int buy_price = 0;
        int sell_price = 0;
        int profit = 0;
        while (i < prices.length) {
            while (i < prices.length - 1 && prices[i] > prices[i + 1]) {
                i++;
            }
            buy_price = prices[i];
            while (i < prices.length - 1 && prices[i] < prices[i + 1]) {
                i++;
            }
            sell_price = prices[i];
            profit += sell_price - buy_price;
            i++;
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }
}
