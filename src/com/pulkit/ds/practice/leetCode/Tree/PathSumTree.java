package com.pulkit.ds.practice.leetCode.Tree;

//Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
//Note: A leaf is a node with no children.
public class PathSumTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		int sum = 22;
		boolean hasPathSum = hasPathSum(root,sum);
		System.out.println(hasPathSum);
	}

	private static boolean hasPathSum(TreeNode root, int sum) {
		if(root==null){
			return false;
		}
		sum = sum-root.val;
		if(root.left==null && root.right==null && sum==0){
			return true;
		}
		return hasPathSum(root.left, sum) || hasPathSum(root.right,sum);
	}

}
