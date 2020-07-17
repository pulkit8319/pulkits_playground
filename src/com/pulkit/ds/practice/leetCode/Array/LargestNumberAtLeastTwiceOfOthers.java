package com.pulkit.ds.practice.leetCode.Array;

//In a given integer array nums, there is always exactly one largest element.
//Find whether the largest element in the array is at least twice as much as every other number in the array.
//If it is, return the index of the largest element, otherwise return -1.
public class LargestNumberAtLeastTwiceOfOthers {

	public static void main(String[] args) {
		int nums[] = {1, 2, 3, 4};
		int index = dominantIndexOptimized(nums);
		System.out.println(index);
	}

	private static int dominantIndexOptimized(int[] nums) {
		int max = Integer.MIN_VALUE,max2 = 0;
		int index = -1;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]>max){
				max2 = max;
				max = nums[i];
				index = i;
			}else if(nums[i]>max2){
				max2 = nums[i];
			}
		}
		return max>=(2*max2)?index:-1;
	}

	private static int dominantIndex(int[] nums) {
		int max = Integer.MIN_VALUE;
		int index = -1;
		for (int i = 0; i < nums.length; i++) {
			if(max<nums[i]){
				max = nums[i];
				index = i;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if(i!=index){
				if(nums[index]<2*nums[i]){
					return -1;
				}
			}
		}
		return index;
	}

}
