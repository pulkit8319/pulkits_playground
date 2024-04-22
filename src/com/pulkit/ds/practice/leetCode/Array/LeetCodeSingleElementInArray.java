package com.pulkit.ds.practice.leetCode.Array;

//Given a non-empty array of integers, every element appears twice except for one. Find that single one.
public class LeetCodeSingleElementInArray {

	public static void main(String[] args) {
		int nums[] = {4,1,2,1,2};
		int num = singleNumber(nums);
		System.out.println(num);
	}

	private static int singleNumber(int[] nums) {
		int num = nums[0];
		for (int i = 1; i < nums.length; i++) {
			num = num^nums[i];
		}
		return num;
	}

	
}
