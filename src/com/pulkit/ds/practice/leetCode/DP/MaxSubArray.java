package com.pulkit.ds.practice.leetCode.DP;

//Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
public class MaxSubArray {

	public static void main(String[] args) {
		int[] nums = {-2,-1/*,-3,4,-1,2,1,-5,4*/};
		int maxSum = maxSubArray(nums);
		System.out.println(maxSum);
	}
     
	private static int maxSubArrayUsingTabulationDP(int[] nums) {
		int n = nums.length;
		int dp[] = new int[n];
		dp[0] = nums[0];
		int sum = nums[0];
		for (int i = 1; i < dp.length; i++) {
			dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
			sum = Math.max(sum, dp[i]);
		}
		return sum;
	}
	
	private static int maxSubArray(int[] nums) {
		int sum = nums[0];
		int maxSum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum = Math.max(nums[i], sum+nums[i]);
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}

}
