package com.pulkit.ds.practice.leetCode.Array;

//Say you have an array for which the ith element is the price of a given stock on day i.
//If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
//Note that you cannot sell a stock before you buy one.
public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		int prices[] = { 7, 1, 5, 3, 6, 4 };
		int profit = maxProfit(prices);
		System.out.println(profit);
	}

	private static int maxProfit(int[] prices) {
		int profit = 0;
		if (prices.length > 0) {
			int minPrice = Integer.MAX_VALUE;
			for (int i = 0; i < prices.length; i++) {
				minPrice = Math.min(minPrice, prices[i]);
				profit = Math.max(profit, prices[i] - minPrice);
			}
		}
		return profit;
	}
}
