package com.pulkit.ds.practice.leetCode.Array;

//Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
public class LongestContinuousIncreasingSubsequence {

	public static void main(String[] args) {
		int nums[] = { 1, 3, 5, 4, 2, 3, 4, 5 };
		int len = findLengthOfLCIS(nums);
		System.out.println(len);
	}

	private static int findLengthOfLCIS(int[] nums) {
		int count = 1;
		int max = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] < nums[i + 1]) {
				count++;
			} else {
				max = Math.max(max, count);
				count = 1;
			}
		}
		if (nums.length > 0) {
			max = Math.max(max, count);
		}
		return max;
	}

}
