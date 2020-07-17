package com.pulkit.ds.practice.leetCode.Array;

//Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
//Return the answer in an array.
public class HowManyNumberAreSmallerThanTheCurrentNumber {

	public static void main(String[] args) {
		int nums[] = { 5, 0, 10, 0, 10, 6 };
		int[] arr = smallerNumbersThanCurrent(nums);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}

	private static int[] smallerNumbersThanCurrent(int[] nums) {
		int[] arr = new int[101];
		int num[] = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			arr[nums[i]]++;
		}
		for (int i = 1; i < arr.length; i++) {
			arr[i] += arr[i - 1];
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				num[i]=0;
			} else {
				num[i] = arr[nums[i] - 1];
			}
		}
		return num;
	}

}
