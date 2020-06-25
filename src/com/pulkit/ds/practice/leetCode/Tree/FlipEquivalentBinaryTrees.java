package com.pulkit.ds.practice.leetCode.Tree;

//For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.
//A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.
//Write a function that determines whether two binary trees are flip equivalent.  The trees are given by root nodes root1 and root2.

public class FlipEquivalentBinaryTrees {

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(0);
		root1.left = new TreeNode(3);
		root1.right = new TreeNode(1);
		root1.right.right = new TreeNode(2);

		TreeNode root2 = new TreeNode(0);
		root2.left = new TreeNode(3);
		root2.right = new TreeNode(1);
		root2.left.left = new TreeNode(2);
		boolean areFlipEquivalent = flipEquiv(root1, root2);
		System.out.println(areFlipEquivalent);
	}

	private static boolean flipEquiv(TreeNode root1, TreeNode root2) {
		if (root1 == root2) {
			return true;
		}
		if (root1 == null || root2 == null || root1.val != root2.val) {
			return false;
		}
		return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
				|| (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
	}

}
