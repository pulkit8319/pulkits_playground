package com.pulkit.ds.practice.leetCode.Array;

//Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).
public class MaximumProductOfTwoElements {

	public static void main(String[] args) {
		int nums[] = { 10, 2, 5, 2 };
		int pdt = maxProduct(nums);
		System.out.println(pdt);
	}

	private static int maxProduct(int[] nums) {
		int max = Integer.MIN_VALUE, max2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= max) {
				max2 = max;
				max = nums[i];
			} else if (nums[i] > max2) {
				max2 = nums[i];
			}
		}
		return (max - 1) * (max2 - 1);
	}

}
