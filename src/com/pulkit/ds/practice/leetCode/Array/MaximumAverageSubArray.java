package com.pulkit.ds.practice.leetCode.Array;

//Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
public class MaximumAverageSubArray {

	public static void main(String[] args) {
		int nums[] = {0,4,0,3,2};
		double avg = findMaxAverage(nums, 1);
		System.out.println(avg);
	}

	private static double findMaxAverage(int[] nums, int k) {
		int sum = 0;
		for (int j = 0; j < k; j++) {
			sum+=nums[j];
		}
		int maxAvg = sum;
		for(int i = k;i<nums.length;i++){
			sum = sum-nums[i-k]+nums[i];
			maxAvg = Math.max(maxAvg, sum);
		}
		return (double)maxAvg/k;
	}

}
