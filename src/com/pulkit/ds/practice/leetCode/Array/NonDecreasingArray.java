package com.pulkit.ds.practice.leetCode.Array;

//Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
//We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
public class NonDecreasingArray {

	public static void main(String[] args) {
		int[] nums = {4,2,3};
		boolean b = checkPossibility(nums);
		System.out.println(b);
	}

	private static boolean checkPossibility(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length-1; i++) {
			if(nums[i]>nums[i+1]){
				count++;
			}
		}
		return count==1;
	}

}
