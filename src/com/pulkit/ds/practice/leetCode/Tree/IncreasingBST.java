package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.List;

//Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.
public class IncreasingBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode	(22);
		TreeNode node = increasingBSTOptimized(root);
		node.inOrder(node);
	}

	static TreeNode ans;
	private static TreeNode increasingBSTOptimized(TreeNode root) {
		TreeNode node = new TreeNode(0);
		ans = node;
		inOrder(root);
		return node.right;
	}

	private static void inOrder(TreeNode root) {
		if(root==null){
			return;
		}
		inOrder(root.left);
		ans.right = root;
		ans.left = null;
		ans = ans.right;
		inOrder(root.right);
	}

	private static TreeNode increasingBST(TreeNode root) {
		if(root==null){
			return null;
		}
		List<TreeNode> list = new ArrayList<>();
		inorder(root,list);
		for(int i=0;i<list.size()-1;i++){
			TreeNode node = list.get(i);
			node.right = list.get(i+1);
			node.left = null;
		}
		return list.get(0);
	}

	private static void inorder(TreeNode root, List<TreeNode> list) {
		if(root==null){
			return;
		}
		inorder(root.left, list);
		list.add(root);
		inorder(root.right, list);
	}

}
