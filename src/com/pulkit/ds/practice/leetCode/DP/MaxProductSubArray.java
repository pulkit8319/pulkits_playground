package com.pulkit.ds.practice.leetCode.DP;

//Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
public class MaxProductSubArray {

	public static void main(String[] args) {
		int[] nums = {-2,3,-4};
		int maxPdt = maxProduct(nums);
		System.out.println(maxPdt);
	}

	private static int maxProduct(int[] nums) {
		int len = nums.length;
		if(len==0){     
			return 0;
		}
		if(len==1){
			return nums[0];
		}
		int maxPdt = nums[0];
		int max = nums[0];
		int min = nums[0];   
		for (int i = 1; i < len; i++) {
			if(nums[i]<0){
   				int temp = max;
				max = min;
				min = temp;
			}
			max = Math.max(nums[i], max*nums[i]);
			min = Math.min(nums[i], min*nums[i]);
			maxPdt = Math.max(maxPdt, max);
		}
		return maxPdt;
	}

}
