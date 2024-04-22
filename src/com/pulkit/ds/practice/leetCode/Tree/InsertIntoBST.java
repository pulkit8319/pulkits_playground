package com.pulkit.ds.practice.leetCode.Tree;

//Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
//Note that there may exist multiple valid ways for the insertion,as long as the tree remains a BST after insertion.You can return any of them.
public class InsertIntoBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(7);

		TreeNode node = insertIntoBSTIterative(root, 3);
		node.inOrder(root);
	}

	private static TreeNode insertIntoBSTIterative(TreeNode root, int val) {
		if(root==null){
			return new TreeNode(val);
		}
		TreeNode node = root;
		while(node!=null){
			if(node.val>val){
				if(node.left!=null){
					node = node.left;
				}else{
					node.left = new TreeNode(val);
					return root;
				}
			}else{
				if(node.right!=null){
					node = node.right;
				}else{
					node.right = new TreeNode(val);
					return root;
				}
			}
		}
		return root;
	}

	private static TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		if (root.val > val) {
			root.left = insertIntoBST(root.left, val);
		} else {
			root.right = insertIntoBST(root.right, val);
		}
		return root;
	}

}
