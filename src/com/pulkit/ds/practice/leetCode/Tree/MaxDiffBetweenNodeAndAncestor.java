package com.pulkit.ds.practice.leetCode.Tree;

//Given a binary tree, return the sum of values of its deepest leaves.
public class MaxDiffBetweenNodeAndAncestor {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(21);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(15);

		int sum = maxAncestorDiff(root);
		System.out.println(sum);
	}

	static int maxDiff = 0;
	private static int maxAncestorDiff(TreeNode root) {
		if(root!=null){
			maxAncestorDiff(root,root.val,root.val);
		}
		return maxDiff;
	}
	private static void maxAncestorDiff(TreeNode root, int minValue, int maxValue) {
		if(root==null){
			return;
		}
		minValue = Math.min(root.val, minValue);
		maxValue = Math.max(root.val, maxValue);
		maxDiff = Math.max(maxDiff, maxValue-minValue);
		maxAncestorDiff(root.left, minValue, maxValue);
		maxAncestorDiff(root.right, minValue, maxValue);
	}

}
