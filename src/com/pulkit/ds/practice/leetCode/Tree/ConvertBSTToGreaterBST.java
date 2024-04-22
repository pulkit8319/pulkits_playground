package com.pulkit.ds.practice.leetCode.Tree;

//Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
public class ConvertBSTToGreaterBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.right = new TreeNode(7);
		root.left = new TreeNode(4);
		TreeNode node = convertBST(root);
		node.inOrder(node);
	}

	static int sum = 0;
	private static TreeNode convertBST(TreeNode root) {
		if(root!=null){
			convertBST(root.right);
			sum = sum + root.val;
			root.val = sum;
			convertBST(root.left);
		}
		return root;
	}
}
