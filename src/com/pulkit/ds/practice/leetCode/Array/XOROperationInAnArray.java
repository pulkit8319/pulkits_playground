package com.pulkit.ds.practice.leetCode.Array;

//Given an integer n and an integer start.
//Define an array nums where nums[i] = start + 2*i (0-indexed) and n == nums.length.
//Return the bitwise XOR of all elements of nums.
public class XOROperationInAnArray {

	public static void main(String[] args) {
		int ans = xorOperation(5,0);
		System.out.println(ans);
	}

	private static int xorOperation(int n, int start) {
		//int[] num = new int[n];
		int num = start;
		int ans = start;
		for (int i = 1; i < n; i++) {
			num = start + 2*i;
			ans = ans^num;
		}
		return ans;
	}

}
