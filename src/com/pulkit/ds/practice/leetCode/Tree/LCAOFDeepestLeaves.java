package com.pulkit.ds.practice.leetCode.Tree;

//Given a rooted binary tree, return the lowest common ancestor of its deepest leaves.
//Recall that:
//The node of a binary tree is a leaf if and only if it has no children
//The depth of the root of the tree is 0, and if the depth of a node is d, the depth of each of its children is d+1.
//The lowest common ancestor of a set S of nodes is the node A with the largest depth such that every node in S is in the subtree with root A.

public class LCAOFDeepestLeaves {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		// root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.left.left.right = new TreeNode(6);
		root.left.right.right = new TreeNode(5);
		TreeNode node = lcaDeepestLeaves(root);
		System.out.println(node);
	}

	private static TreeNode lcaDeepestLeaves(TreeNode root) {
		if (root == null) {
			return null;
		}
		int left = height(root.left);
		int right =  height(root.right);
		if(left==right){
			return root;
		}else if(left>right){
			return lcaDeepestLeaves(root.left);
		}else{
			return lcaDeepestLeaves(root.right);
		}
	}

	private static int height(TreeNode root) {
		if(root==null){
			return 0;
		}
		return Math.max(height(root.left), height(root.right))+1;
	}

}
