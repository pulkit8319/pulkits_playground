package com.pulkit.ds.practice.leetCode.Tree;

//Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
//The root is the maximum number in the array.
//The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
//The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
//Construct the maximum tree by the given array and output the root node of this tree.
public class MaximumBinaryTree {

	public static void main(String[] args) {
		int nums[] = { 3, 2, 1, 6, 0, 5 };
		TreeNode root = constructMaximumBinaryTree(nums);
	}

	private static TreeNode constructMaximumBinaryTree(int[] nums) {
		if (nums.length == 0) {
			return null;
		}
		return constructMaximumBinaryTree(nums, 0, nums.length - 1);
	}

	private static TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
		if(start>end){
			return null;
		}
		int index = getMaxIndex(nums,start,end);
		TreeNode root = new TreeNode(nums[index]);
		if(start==end){
			return root;
		}
		root.left = constructMaximumBinaryTree(nums,start,index-1);
		root.right = constructMaximumBinaryTree(nums,index+1,end);
		return root;
	}

	private static int getMaxIndex(int[] nums, int start, int end) {
		if (start == end) {
			return start;
		}
		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		for (int i = start; i <= end; i++) {
			if (max < nums[i]) {
				max = nums[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}

}
