package com.pulkit.ds.practice.leetCode.Tree;

//Given a binary tree root and an integer target, delete all the leaf nodes with value target.
//Note that once you delete a leaf node with value target, if it's parent node becomes a leaf node and has the value target, it should also be deleted (you need to continue doing that until you can't).
public class DeleteLeavesWithAGivenValue {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(2);
		int target = 2;
		TreeNode node = removeLeafNodes(root, target);
		node.inOrder(node);
	}

	private static TreeNode removeLeafNodes(TreeNode root, int target) {
		if(root==null){
			return null;
		}
		root.left = removeLeafNodes(root.left, target);
		root.right = removeLeafNodes(root.right, target);
		if(root.left==null && root.right==null && root.val == target){
			return null;
		}
		return root;
	}

}
