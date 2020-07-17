package com.pulkit.ds.practice.leetCode.Array;

//Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
//Return the running sum of nums.
public class RunningSumOf1DArray {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		int[] arr = runningSum(nums);
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j]);
		}
	}

	private static int[] runningSum(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			nums[i] +=nums[i-1];
		}
		return nums;
	}

}
