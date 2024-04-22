package com.pulkit.ds.practice.leetCode.Tree;

import java.util.Stack;

//Given a binary tree, flatten it to a linked list in-place.

public class FlattenBinaryTreeToLinkedList {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(27);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(17);
		root.right.right = new TreeNode(7);
		flattenIterative(root);
		root.inOrder(root);
	}

	private static void flattenIterative(TreeNode root) {
		Stack<TreeNode> stk = new Stack<TreeNode>();
		preOrder(root,stk);
		for(int i=0;i<stk.size()-1;i++){
			TreeNode pop = stk.get(i);
			pop.left = null;
			pop.right = stk.get(i+1);
		}
	}

	private static void preOrder(TreeNode root, Stack<TreeNode> stk) {
		if(root==null){
			return;
		}
		stk.add(root);
		preOrder(root.left, stk);
		preOrder(root.right, stk);
	}

	static TreeNode prev;
	private static void flatten(TreeNode root) {
		if(root==null){
			return;
		}
		flatten(root.right);
		flatten(root.left);
		root.left = null;
		root.right = prev;
		prev = root;
	}

}
