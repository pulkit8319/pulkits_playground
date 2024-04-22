package com.pulkit.ds.practice.leetCode.Tree;

//Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
//For all leaves in the tree,consider the numbers represented by the path from the root to that leaf.
//Return the sum of these numbers.

public class SumOfRootToLeafBinaryNumber {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(0);
		int sum = sumRootToLeaf(root);
		System.out.println(sum);
	}

	static int sum = 0;

	private static int sumRootToLeaf(TreeNode root) {
		getSum(root, 0);
		return sum;
	}

	private static void getSum(TreeNode root, int val) {
		if (root == null) {
			return;
		}
		val = val<<1 | root.val;
		if(root.left==null && root.right==null){
			sum += val;
		}
		getSum(root.left, val);
		getSum(root.right, val);
	}

}
