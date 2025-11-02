package Easy;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        // Initialize the maximum profit to 0
        int maxProfit = 0;
        // Initialize the minimum price to the maximum possible value
        int minPrice = Integer.MAX_VALUE;

        // Iterate through the prices array
        for (int price : prices) {
            // Update the minimum price if the current price is lower
            minPrice = Math.min(minPrice, price);
            // Calculate the potential profit by subtracting the minimum price from the current price
            int potentialProfit = price - minPrice;
            // Update the maximum profit if the potential profit is higher
            maxProfit = Math.max(maxProfit, potentialProfit);
        }

        // Return the maximum profit
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();

        // Test case 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int maxProfit1 = solution.maxProfit(prices1);
        System.out.println("Max profit is: " + maxProfit1);
    }
}
