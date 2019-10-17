package com.pulkit.ds.practice.leetCode.Array;

//Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
public class LeetCodeArrayMoveZeroes {

	public static void main(String[] args) {
		int nums[] = {0,1,0,3,12};
		int newNum[] = moveZeroes(nums);
		for (int i = 0; i < newNum.length; i++) {
			System.out.print(newNum[i]);
		}
	}

	private static int[] moveZeroes(int[] nums) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]!=0) {
				nums[index++] = nums[i];
			}
		}
		for(int i = index;i<nums.length;i++) {
			nums[i]=0;
		}
		return nums;
	}

}
