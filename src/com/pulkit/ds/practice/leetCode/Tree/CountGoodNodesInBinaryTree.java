package com.pulkit.ds.practice.leetCode.Tree;

//Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
//Return the number of good nodes in the binary tree.

public class CountGoodNodesInBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(5);

		int count = goodNodes(root);
		System.out.println(count);
	}

	private static int goodNodes(TreeNode root) {
		return goodNodes(root, Integer.MIN_VALUE);
	}

	private static int goodNodes(TreeNode root, int max) {
		if (root == null) {
			return 0;
		}
		max = Math.max(max, root.val);
		return (root.val >= max ? 1 : 0) + goodNodes(root.left, max) + goodNodes(root.right, max);
	}

}
