package com.pulkit.ds.practice.leetCode.Array;

//Given an array of integers nums, you start with an initial positive value startValue.
//In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).
//Return the minimum positive value of startValue such that the step by step sum is never less than 1.
public class MinValueToGetPositiveSum {

	public static void main(String[] args) {
		int nums [] = {-3,2,-3,4,2};
		int num = minStartValue(nums);
		System.out.println(num);
	}

	private static int minStartValue(int[] nums) {
		int sum = 0;
		int num = 1;
		for (int i = 0; i < nums.length; i++) {
			sum+=nums[i];
			if(sum<=0){
				num += Math.abs(sum);
				sum = 0;
			}
		}
		return num;
	}

}
