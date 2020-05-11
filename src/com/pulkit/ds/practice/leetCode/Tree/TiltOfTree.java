package com.pulkit.ds.practice.leetCode.Tree;

//Given a binary tree, return the tilt of the whole tree.
//The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values.Null node has tilt 0.
//The tilt of the whole tree is defined as the sum of all nodes' tilt.
public class TiltOfTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.right = new TreeNode(7);
		root.left = new TreeNode(4);
		int tilt = findTilt(root);
		System.out.println(tilt);
	}
	
	static int tilt = 0;

	private static int findTilt(TreeNode root) {
		tilt(root);
		return tilt;
	}

	private static int tilt(TreeNode root) {
		if(root==null){
			return 0;
		}
		int leftTilt = tilt(root.left);
		int rightTilt = tilt(root.right);
		tilt = tilt+Math.abs(leftTilt-rightTilt);
		return leftTilt+rightTilt+root.val;
	}
	
	

}
