package com.pulkit.ds.practice.leetCode.Tree;

public class MaxDepth {

	public static void main(String[] args) {
		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(2);
		p.right = new TreeNode(3);

		int maxDepth = maxDepth(p);
		System.out.println(maxDepth);
	}

	private static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

}
