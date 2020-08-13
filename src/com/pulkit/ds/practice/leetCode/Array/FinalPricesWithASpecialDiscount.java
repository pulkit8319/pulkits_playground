package com.pulkit.ds.practice.leetCode.Array;

import java.util.ArrayList;
import java.util.Stack;

//Given the array prices where prices[i] is the price of the ith item in a shop. There is a special discount for items in the shop, if you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i], otherwise, you will not receive any discount at all.
//Return an array where the ith element is the final price you will pay for the ith item of the shop considering the special discount.
public class FinalPricesWithASpecialDiscount {

	public static void main(String[] args) {
		int prices[] = {1,2,3,4,5};
		int[] nums = finalPricesOptimized(prices);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

	private static int[] finalPricesOptimized(int[] prices) {
		Stack<Integer> stk = new Stack<Integer>();
		for (int i = 0; i < prices.length; i++) {
			while(!stk.isEmpty() && prices[stk.peek()]>=prices[i]){
				prices[stk.pop()]-=prices[i];
			}
			stk.push(i);
		}
		return prices;
	}

	private static int[] finalPrices(int[] prices) {
		for (int i = 0; i < prices.length-1; i++) {
			for(int j=i+1;j<prices.length;j++){
				if(prices[j]<=prices[i]){
					prices[i]-=prices[j];
					break;
				}
			}
		}
		return prices;
	}

}
