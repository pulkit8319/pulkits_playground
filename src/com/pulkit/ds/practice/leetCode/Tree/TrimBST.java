package com.pulkit.ds.practice.leetCode.Tree;

//Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.
public class TrimBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(0);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(1);
		int l = 4, r = 4;
		TreeNode node = trimBST(root, l, r);
		node.inOrder(node);
	}

	private static TreeNode trimBST(TreeNode root, int L, int R) {
		if (root == null) {
			return null;
		}
		root.left = trimBST(root.left, L, R);
		root.right = trimBST(root.right, L, R);
		int k = root.val;
		if (k < L) {
			return root.right;
		} else if (k > R) {
			return root.left;
		}
		return root;
	}

}
