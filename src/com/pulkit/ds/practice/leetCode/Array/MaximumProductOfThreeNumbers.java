package com.pulkit.ds.practice.leetCode.Array;

//Given an integer array, find three numbers whose product is maximum and output the maximum product.
public class MaximumProductOfThreeNumbers {

	public static void main(String[] args) {
		int nums[] = {-4,-3,-2,-1,60};
		int pdt = maximumProduct(nums);
		System.out.println(pdt);
	}

	private static int maximumProduct(int[] nums) {
		int max = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE,min2 = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= max) {
				max3 = max2;
				max2 = max;
				max = nums[i];
			} else if (nums[i] > max2) {
				max3 = max2;
				max2 = nums[i];
			} else if (nums[i] > max3) {
				max3 = nums[i];
			}
			if(nums[i]<=min){
				min2 = min;
				min = nums[i];
			}else if(nums[i]<min2){
				min2 = nums[i];
			}
		}
		return Math.max(max * max2 * max3,min*min2*max);
	}

}
