package com.pulkit.ds.practice.leetCode.Array;

//Given an array, rotate the array to the right by k steps, where k is non-negative.
public class LeetCodeRotateArray {

	public static void main(String[] args) {
		int nums[] = {1,2,3,4,5,6,7};//1,2,3,1,2,0,0
		int arr[] = rotate(nums, 3);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	private static int[] rotate(int[] nums, int k) {
		int temp[] =new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			temp[i] = nums[i];
		}
		int length = nums.length;
		for(int i=0;i<temp.length;i++) {
			nums[(i+k)%length] = temp[i];
		}
		return nums;
	}

}
