package com.pulkit.ds.practice.leetCode.DP;

//You are climbing a stair case. It takes n steps to reach to the top.
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//Note: Given n will be a positive integer.
public class ClimbingStairs {

	public static void main(String[] args) {
		int noOfWays = climbStairsDPMemoization(5);
		System.out.println(noOfWays);
	}

	private static int climbStairsDPTabulation(int n) {
		if(n==1 || n==2){
			return n;
		}
		int dp[] = new int[n];
		dp[0] = 1;
		dp[1] = 2;
		for (int i = 2; i < n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n - 1];
	}
	
	private static int climbStairsDPMemoization(int n) {
		int dp[] = new int[n];
		return climbStairsDPMemoization(dp,n);
	}

	private static int climbStairsDPMemoization(int[] dp, int n) {
		if(n==1 || n==2 || n==0){
			return n;
		}
		if(dp[n-1]!=0){
			return dp[n-1];
		}else{
			dp[n-1] = climbStairsDPMemoization(dp,n-1) + climbStairsDPMemoization(dp,n-2);
		}
		return dp[n-1];
	}

	private static int climbStairs(int n) {
		if (n == 1 || n == 2) {
			return n;
		}
		return climbStairs(n - 1) + climbStairs(n - 2);
	}

}
