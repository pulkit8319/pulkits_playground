package com.pulkit.ds.practice.leetCode.Array;

//Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
public class ThirdMaximumNumber {

	public static void main(String[] args) {
		int[] arr = {1,2};
		int nums = thirdMax(arr);
		System.out.println(nums);
	}

	private static int thirdMax(int[] nums) {
		int max = nums[0];
		Integer max1 = null;
		Integer max2 = null;
		for (int i = 1; i < nums.length; i++) {
			if(nums[i]==max || (max2!=null && nums[i]==max2) || (max1!=null && nums[i]==max1)){
				continue;
			}
			if (nums[i] > max) {
				max2 = max1;
				max1 = max;
				max = nums[i];
			} else if (max1==null || nums[i] > max1) {
				max2 = max1;
				max1 = nums[i];
			} else if (max2==null || nums[i] > max2) {
				max2 = nums[i];
			}
		}
		return max2 == null ? max : max2;
	}

}
