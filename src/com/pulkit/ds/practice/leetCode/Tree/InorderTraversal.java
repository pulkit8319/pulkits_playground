package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Given a binary tree, return the inorder traversal of its nodes' values.
public class InorderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		List<Integer> list = inorderTraversalIterative(root);
		System.out.println(list);
	}

	private static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		inorder(root, list);
		return list;
	}

	private static void inorder(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		inorder(root.left, list);
		list.add(root.val);
		inorder(root.right, list);
	}

	private static List<Integer> inorderTraversalIterative(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stk = new Stack<TreeNode>();
		TreeNode current = root;
		while (current != null) {
			stk.push(current);
			current = current.left;
			while(current == null && !stk.isEmpty()) {
				current = stk.pop();
				list.add(current.val);
				current = current.right;
			}
		}
		return list;
	}
}
