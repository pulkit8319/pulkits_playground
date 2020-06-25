package com.pulkit.ds.practice.leetCode.Tree;

//Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.
//The length of path between two nodes is represented by the number of edges between them.

public class LongestUnivaluePath {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(5);
		//root.right.right = new TreeNode(5);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(4);

		int longestUnivaluePath = longestUnivaluePath(root);
		System.out.println(longestUnivaluePath);
	}

	static int ans = 0;

	private static int longestUnivaluePath(TreeNode root) {
		getLongestUniValuePath(root);
		return ans;
	}

	private static int getLongestUniValuePath(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getLongestUniValuePath(root.left);
		int right = getLongestUniValuePath(root.right);
		int aL = 0, aR = 0;
		if (root.left != null && root.left.val == root.val) {
			aL += left + 1;
		}
		if (root.right != null && root.right.val == root.val) {
			aR += right + 1;
		}
		ans = Math.max(ans, aL + aR);
		return Math.max(aL, aR);
	}

}
