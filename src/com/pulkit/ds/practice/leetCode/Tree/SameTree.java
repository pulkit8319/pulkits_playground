package com.pulkit.ds.practice.leetCode.Tree;

//Given two binary trees, write a function to check if they are the same or not.

//Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
public class SameTree {

	public static void main(String[] args) {
		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(2);
		// p.right = new TreeNode(3);

		TreeNode q = new TreeNode(1);
		// q.left = new TreeNode(2);
		q.right = new TreeNode(3);

		boolean isSameTree = isSameTree(p, q);
		System.out.println(isSameTree);
	}

	private static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null || q == null) {
			return p == q;
		}
		if (p != null && q != null && p.val != q.val) {
			return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

}
