package com.pulkit.ds.practice.leetCode.DP;

//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
public class HouseRobber {

	public static void main(String[] args) {
		int[] nums = {2,7,9,3,1};
		int maxMoney = robUsingTwoVariables(nums);
		System.out.println(maxMoney);
	}

	private static int rob(int[] nums) {
		int size = nums.length;
		if(size==0){
			return 0;
		}
		if(size==1){
			return nums[0];
		}
		int dp[] = new int[size];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for(int i=2;i<size;i++){
			dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
		}
		return dp[size-1];
	}
	
	private static int robUsingTwoVariables(int[] nums) {
		int size = nums.length;
		if(size==0){
			return 0;
		}
		if(size==1){
			return nums[0];
		}
		int f1 = nums[0];
		int f2 = Math.max(nums[0], nums[1]);
		int max = f2;
		for(int i=2;i<size;i++){
			max = Math.max(f2, f1+nums[i]);
			f1 = f2;
			f2 = max;
		}
		return max;
	}

}
