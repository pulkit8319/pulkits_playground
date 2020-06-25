package com.pulkit.ds.practice.leetCode.Tree;

//Given a non-empty binary tree, find the maximum path sum.
//For this problem,a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.The path must contain at least one node and does not need to go through the root.

public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		// root.left.right.left = new TreeNode(1);
		/*
		 * root.right.left = new TreeNode(15); root.right.right = new
		 * TreeNode(7);
		 */
		// root.right.left.left = new TreeNode(6);
		// root.right.left.right = new TreeNode(8);

		int sum = maxPathSum(root);
		System.out.println(sum);
	}

	static int maxSum = Integer.MIN_VALUE;

	private static int maxPathSum(TreeNode root) {
		findMaxSum(root);
		return maxSum;
	}

	private static int findMaxSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftSum = Math.max(0, findMaxSum(root.left));
		int rightSum =  Math.max(0,findMaxSum(root.right));
		maxSum = Math.max(maxSum, leftSum + rightSum + root.val);
		return Math.max(leftSum, rightSum)+root.val;
	}

}
