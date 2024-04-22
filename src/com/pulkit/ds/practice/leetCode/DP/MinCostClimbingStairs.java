package com.pulkit.ds.practice.leetCode.DP;

//On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
//Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
public class MinCostClimbingStairs {

	public static void main(String[] args) {
		int[] cost = { 10, 15, 20 };
		int minCost = minCostClimbingStairsSpace(cost);
		System.out.println(minCost);
	}

	private static int minCostClimbingStairsModifyingCostArray(int[] cost) {
		int n = cost.length;
		for (int i = 2; i < n; i++) {
			cost[i] += Math.min(cost[i - 1], cost[i - 2]);
		}
		return Math.min(cost[n - 1], cost[n - 2]);
	}
	
	private static int minCostClimbingStairsDP(int[] cost) {
		int n = cost.length;
		int dp[] = new int[n];
		dp[0] = cost[0];
		dp[1] = cost[1];
		for (int i = 2; i < n; i++) {
			dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
		}
		return Math.min(dp[n - 1], dp[n - 2]);
	}
	
	private static int minCostClimbingStairsSpace(int[] cost) {
		int cost1 = cost[0];
		int cost2 = cost[1];
		for (int i = 2; i < cost.length; i++) {
			int currCost = cost[i] + Math.min(cost1, cost2);
			cost1 = cost2;
			cost2 = currCost;
		}
		return Math.min(cost1,cost2);
	}

}
