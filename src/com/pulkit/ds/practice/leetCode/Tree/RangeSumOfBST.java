package com.pulkit.ds.practice.leetCode.Tree;

//Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
//The binary search tree is guaranteed to have unique values.
public class RangeSumOfBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		root.left.left.right = new TreeNode(18);
		int L = 7, R = 15;
		int sum = rangeSumBSTOptimised(root, L, R);
		System.out.println(sum);
	}

	private static int rangeSumBSTOptimised(TreeNode root, int L, int R) {
		if (root == null) {
			return 0;
		}
		if(root.val>=L && root.val<=R) {
			return rangeSumBSTOptimised(root.left, L, R)+rangeSumBSTOptimised(root.right, L, R)+root.val;
		}else if (root.val < L) {
			return rangeSumBSTOptimised(root.right, L, R);
		}else{
			return rangeSumBSTOptimised(root.left, L, R);
		}
	}

	static int sum = 0;

	private static int rangeSumBST(TreeNode root, int L, int R) {
		if (root == null) {
			return sum;
		}
		if (root.val >= L && root.val <= R) {
			sum += root.val;
		}
		rangeSumBST(root.left, L, R);
		rangeSumBST(root.right, L, R);
		return sum;
	}

}
