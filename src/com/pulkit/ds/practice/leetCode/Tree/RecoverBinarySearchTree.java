package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		root.inOrder(root);
		recoverTreeOptimised(root);
		root.inOrder(root);
	}

	static TreeNode firstElmnt = null;
	static TreeNode secondElmnt = null;
	static TreeNode prevElmnt = new TreeNode(Integer.MIN_VALUE);

	private static void recoverTreeOptimised(TreeNode root) {
		traverse(root);
		if (firstElmnt != null) {
			int temp = firstElmnt.val;
			firstElmnt.val = secondElmnt.val;
			secondElmnt.val = temp;
		}
	}

	private static void traverse(TreeNode root) {
		if (root == null) {
			return;
		}
		traverse(root.left);
		if (firstElmnt == null && prevElmnt.val > root.val) {
			firstElmnt = prevElmnt;
		}
		if (firstElmnt != null && prevElmnt.val > root.val) {
			secondElmnt = root;
		}
		prevElmnt = root;
		traverse(root.right);
	}

	private static void recoverTree(TreeNode root) {
		if (root == null) {
			return;
		}
		List<TreeNode> list = new ArrayList<>();
		inorder(list, root);
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				TreeNode n1 = list.get(i);
				TreeNode n2 = list.get(j);
				if (n1.val > n2.val) {
					int temp = n1.val;
					n1.val = n2.val;
					n2.val = temp;
				}
			}
		}
	}

	private static void inorder(List<TreeNode> list, TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(list, root.left);
		list.add(root);
		inorder(list, root.right);
	}

}
