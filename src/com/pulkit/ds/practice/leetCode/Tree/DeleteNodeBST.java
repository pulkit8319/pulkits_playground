package com.pulkit.ds.practice.leetCode.Tree;

//Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
//Basically, the deletion can be divided into two stages:
//Search for a node to remove.
//If the node is found, delete the node.
//Note: Time complexity should be O(height of tree).
public class DeleteNodeBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(7);

		TreeNode node = deleteNode(root, 3);
		node.inOrder(root);
	}

	private static TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if(key<root.val){
			root.left = deleteNode(root.left, key);
		}
		else if(key>root.val){
			root.right = deleteNode(root.right, key);
		}else{
			if(root.left==null){
				return root.right;
			}else if(root.right==null){
				return root.left;
			}
			root.val = findMin(root.right);
			root.right = deleteNode(root.right, root.val);
		}
		return root;
	}

	private static int findMin(TreeNode root) {
		while(root.left!=null){
			root = root.left;
		}
		return root.val;
	}

}
