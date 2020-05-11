package com.pulkit.ds.practice.leetCode.Tree;

//Given a binary tree, determine if it is height-balanced.
public class HeightBalancedBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(17);
		root.right.right = new TreeNode(7);
		boolean isBalanced = isBalanced(root);
		System.out.println(isBalanced);
	}

	private static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		return (Math.abs(height(root.left) - height(root.right)) < 2) && isBalanced(root.left)
				&& isBalanced(root.right);
	}

	private static int height(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return Math.max(height(node.left), height(node.right)) + 1;
	}

}
