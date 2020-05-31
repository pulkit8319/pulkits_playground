package com.pulkit.ds.practice.leetCode.Tree;

//Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.
//The length of path between two nodes is represented by the number of edges between them.

public class LongestUnivaluePath {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(1);
		
		int longestUnivaluePath = longestUnivaluePath(root);
		System.out.println(longestUnivaluePath);
	}

	static int longestPath = 0, pathNum = 0;

	private static int longestUnivaluePath(TreeNode root) {
		Integer prev = null;
		return longestPath(root, prev);
	}

	private static int longestPath(TreeNode root, Integer prev) {
		if (root == null) {
			return pathNum;
		}
		if (prev != null) {
			if (prev == root.val) {
				pathNum++;
			} 
			if (longestPath < pathNum) {
				longestPath = pathNum;
			}
			if(prev != root.val){
				pathNum = 0;
			}
		}
		prev = root.val;
		longestPath(root.left, prev);
		longestPath(root.right, prev);
		return longestPath;
	}

}
