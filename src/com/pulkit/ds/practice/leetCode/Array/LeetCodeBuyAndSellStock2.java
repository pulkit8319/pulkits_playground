package com.pulkit.ds.practice.leetCode.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Say you have an array for which the ith element is the price of a given stock on day i.
//Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
//Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
public class LeetCodeBuyAndSellStock2 {

	public static void main(String[] args) {
		int prices[] = {7,1,5,3,6,4};
		int maxProfit = maxProfit(prices);
		System.out.println(maxProfit);
	}

	private static int maxProfit(int[] prices) {
		int maxProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			if(prices[i]>prices[i-1]) {
				maxProfit+=prices[i]-prices[i-1];
			}
		}
		return maxProfit;
	}

}
