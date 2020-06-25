package com.pulkit.ds.practice.leetCode.DP;

//A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.
//For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.
//Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.
public class WriggleSequence {

	public static void main(String[] args) {
		int[] nums = { 8, 8, 10, 4 };
		int maxLength = wiggleMaxLengthUsingTwoVariable(nums);
		System.out.println(maxLength);
	}

	private static int wiggleMaxLengthUsingTwoVariable(int[] nums) {
		int size = nums.length;
		if (size == 0 || size == 1) {
			return size;
		}
		int up = 1;
		int down = 1;
		for (int i = 1; i < size; i++) {
			if (nums[i] - nums[i - 1] > 0) {
				up = down + 1;
			} else if (nums[i] - nums[i - 1] < 0) {
				down = up + 1;
			} 
		}
		return Math.max(up, down);
	}

	private static int wiggleMaxLength(int[] nums) {
		int size = nums.length;
		if (size == 0 || size == 1) {
			return size;
		}
		int up[] = new int[size];
		up[0] = 1;
		int down[] = new int[size];
		down[0] = 1;
		for (int i = 1; i < size; i++) {
			if (nums[i] - nums[i - 1] > 0) {
				up[i] = down[i - 1] + 1;
				down[i] = down[i - 1];
			} else if (nums[i] - nums[i - 1] < 0) {
				down[i] = up[i - 1] + 1;
				up[i] = up[i - 1];
			} else {
				up[i] = up[i - 1];
				down[i] = down[i - 1];
			}
		}
		return Math.max(up[size - 1], down[size - 1]);
	}

}
