package com.pulkit.ds.practice.leetCode.Tree;

//Given a binary tree root, a ZigZag path for a binary tree is defined as follow:
//Choose any node in the binary tree and a direction (right or left).
//If the current direction is right then move to the right child of the current node otherwise move to the left child.
//Change the direction from right to left or right to left.
//Repeat the second and third step until you can't move in the tree.
//Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).
//Return the longest ZigZag path contained in that tree.
public class LongestZigzagPathInBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(2);
		int num = longestZigZag(root);
		System.out.print(num);
	}

	static int max = -1;

	private static int longestZigZag(TreeNode root) {
		maxZigZag(root, true);
		return max;
	}

	private static int maxZigZag(TreeNode root, boolean isLeft) {
		if (root == null) {
			return 0;
		}
		int l = maxZigZag(root.left, false);
		int r = maxZigZag(root.right, true);
		max = Math.max(max, l);
		max = Math.max(max, r);
		return 1 + (isLeft ? l : r);
	}

}
