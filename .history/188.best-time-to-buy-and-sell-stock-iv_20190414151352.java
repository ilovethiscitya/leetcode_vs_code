/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
 *
 * algorithms
 * Hard (25.86%)
 * Total Accepted:    83.5K
 * Total Submissions: 319.9K
 * Testcase Example:  '2\n[2,4,1]'
 *
 * Say you have an array for which the i^th element is the price of a given
 * stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most k
 * transactions.
 * 
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must
 * sell the stock before you buy again).
 * 
 * Example 1:
 * 
 * 
 * Input: [2,4,1], k = 2
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit
 * = 4-2 = 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,2,6,5,0,3], k = 2
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit
 * = 6-2 = 4.
 * Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 =
 * 3.
 * 
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        // 必须以当前的数为结尾怎么做呢
        if(k == 0 || prices.length < 2) {
            return 0;
        }
        if(k > prices.length / 2) {
            return noLimit(prices);
        }
        int[][] hold = new int[k + 1][prices.length];
        int[][] unhold = new int[k + 1][prices.length];
        for(int i = 1; i <= k; i++) {
            hold[i][0] = -prices[0];
            unhold[i][0] = 0;
            for(int j = 1; j < prices.length; j++) {
                hold[i][j] = Math.max(unhold[i - 1][j - 1] - prices[j], hold[i][j - 1]);
                unhold[i][j] = Math.max(hold[i][j - 1] + prices[j], unhold[i][j - 1]);
            }
        }
        return unhold[k][prices.length - 1];
    }
    private int noLimit(int[] prices) {
        int sum = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }


    // public int maxProfits(int k, int[] prices) {
    //     if(k > prices.length / 2) {
    //         return noLimit(prices);
    //     }
    //     int[][] hold = new int[k + 1][prices.length];
    //     int[][] unhold = new int[k + 1][prices.length];
    //     for(int i = 1; i <= k; i++) {
    //         hold[i][0] = -prices[0];
    //         unhold[i][0] = 0;
    //         for(int j = 1; j < prices.length; j++) {
    //             hold[i][j] = Math.max(unhold[i - 1][j] - prices[j], hold[i][j - 1]);
    //             unhold[i][j] = Math.max(hold[i][j - 1] + prices[j], unhold[i][j - 1]);
    //         }
    //     }
    //     return unhold[k][prices.length - 1];
    // }
}

