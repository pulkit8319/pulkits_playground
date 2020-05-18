package com.pulkit.ds.practice.leetCode.Tree;

//Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
public class SearchInBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(9);
		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(22);
		int val = 9;
		TreeNode node = searchBSTIterative(root, val);
		System.out.println(node.val);
	}

	private static TreeNode searchBSTIterative(TreeNode root, int val) {
		while(root!=null){
			if(root.val>val){
				root = root.left;
			}else if(root.val<val){
				root = root.right;
			}else{
				return root;
			}
		}
		return null;
	}

	private static TreeNode searchBST(TreeNode root, int val) {
		if (root == null) {
			return root;
		}
		if (root.val > val) {
			return searchBST(root.left, val);
		} else if (root.val < val) {
			return searchBST(root.right, val);
		} else {
			return root;
		}
	}

}
