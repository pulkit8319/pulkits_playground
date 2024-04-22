package com.pulkit.ds.practice.leetCode.DP;

//Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
public class PartitionEqualSubsetSum {
	public static void main(String[] args) {
		int[] nums = {1,2,3,5};
		boolean b = canPartition(nums);
		System.out.println(b);
	}

	private static boolean canPartition(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum+=nums[i];
		}
		if(sum%2!=0){
			return false;
		}
		sum = sum/2;
		int total = 0;
		for (int i = 0; i < nums.length; i++) {
			if(total+nums[i]<=sum){
				total+=nums[i];
			}
			if(total==sum && i==nums.length-1){
				return true;
			}
		}
		return false;
	}

}
