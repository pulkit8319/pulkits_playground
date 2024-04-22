package com.pulkit.ds.practice.leetCode.Tree;

//Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
public class MinAbsDiffBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.right = new TreeNode(7);
		root.left = new TreeNode(4);
		int minDiff = getMinimumDifference(root);
		System.out.println(minDiff);
	}

	static int minDiff = Integer.MAX_VALUE;
	static Integer prev = null;

	private static int getMinimumDifference(TreeNode root) {
		if (root != null) {
			getMinimumDifference(root.left);
			if (prev != null) {
				int diff = Math.abs(root.val - prev);
				if (minDiff > diff) {
					minDiff = diff;
				}
			}
			prev = root.val;
			getMinimumDifference(root.right);
		}
		return minDiff;
	}

}
