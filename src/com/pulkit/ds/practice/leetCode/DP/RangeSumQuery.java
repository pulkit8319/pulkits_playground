package com.pulkit.ds.practice.leetCode.DP;

//Given an integer array nums, find the sum of the elements between indices i and j(i<=j), inclusive.
public class RangeSumQuery {

	int[] sumArray;
	int[] num;

	// Memoization ---- START//
	/*
	 * public RangeSumQuery(int[] nums) { if (nums.length > 0) { this.num =
	 * nums; sumArray = new int[nums.length]; sumArray[0] = nums[0]; for (int i
	 * = 1; i < sumArray.length; i++) { sumArray[i] = Integer.MIN_VALUE; } } }
	 */

	public int sumRange(int i, int j) {
		return sum(j) - sum(i - 1);
	}

	// sum of first i elements of array
	private int sum(int i) {
		if (i < 0) {
			return 0;
		}
		if (sumArray[i] != Integer.MIN_VALUE) {
			return sumArray[i];
		} else {
			sumArray[i] = num[i] + sum(i - 1);
		}
		return sumArray[i];
	}

	// Memoization ---- END//

	// Tabulation ----START//
	public RangeSumQuery(int[] nums) {
		int size = nums.length;
		if (nums.length > 0) {
			sumArray = new int[size + 1];
			for (int i = 0; i < size; i++) {
				sumArray[i + 1] = sumArray[i] + nums[i];
			}
		}
	}

	public int sumRange1(int i, int j) {
		return sumArray[j+1] - sumArray[i];
	}

	// Tabulation ----END//
	public static void main(String[] args) {
		int[] nums = { -2, 0, 3, -5, 2, -1 };
		RangeSumQuery obj = new RangeSumQuery(nums);
		int param_1 = obj.sumRange1(2, 5);
		System.out.println(param_1);
	}
}
