package com.pulkit.ds.practice.leetCode.Tree;

//We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.
//Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
//(Recall that the subtree of a node X is X, plus every node that is a descendant of X.)

public class BinaryTreePruning {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(1);

		TreeNode node = pruneTree(root);
	}

	private static TreeNode pruneTree(TreeNode root) {
		if(root==null){
			return null;
		}
		root.left = pruneTree(root.left);
		root.right = pruneTree(root.right);
		if(root.left==null && root.right==null && root.val==0){
			return null;
		}
		return root;
	}

}
