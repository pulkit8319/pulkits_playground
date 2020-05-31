package com.pulkit.ds.practice.leetCode.Tree;

import java.util.LinkedList;
import java.util.Queue;

//In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
//Two nodes of a binary tree are cousins if they have the same depth,but have different parents.
//We are given the root of a binary tree with unique values,and the values x and y of two different nodes in the tree.
//Return true if and only if the nodes corresponding to the values x and y are cousins.

public class CousinsInBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(5);
		int x = 5, y = 4;
		boolean areCousins = isCousins(root, x, y);
		System.out.println(areCousins);
	}

	private static boolean isCousins(TreeNode root, int x, int y) {
		if (root == null) {
			return false;
		}
		return (findLevel(root, x, 1) == findLevel(root, y, 1)) && !isSibling(root, x, y);
	}

	private static boolean isSibling(TreeNode root, int x, int y) {
		if (root == null) {
			return false;
		}
		return (((root.left != null && root.right != null)
				&& ((root.left.val == x && root.right.val == y) || (root.right.val == x && root.left.val == y)))
				|| isSibling(root.left, x, y) || isSibling(root.right, x, y));
	}

	private static int findLevel(TreeNode root, int x, int level) {
		if (root == null) {
			return 0;
		}
		if (root.val == x) {
			return level;
		}
		int l = findLevel(root.left, x, level + 1);
		if (l != 0) {
			return l;
		}
		return findLevel(root.right, x, level + 1);
	}

	private static boolean isCousinsIterative(TreeNode root, int x, int y) {
		if (root == null) {
			return false;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			boolean xExist = false;
			boolean yExist = false;
			while (size > 0) {
				TreeNode curr = q.poll();
				if (curr.val == x) {
					xExist = true;
				}
				if (curr.val == y) {
					yExist = true;
				}
				if (curr.left != null && curr.right != null) {
					if ((curr.left.val == x && curr.right.val == y) || (curr.right.val == x && curr.left.val == y)) {
						return false;
					}
				}
				if (curr.left != null) {
					q.add(curr.left);
				}
				if (curr.right != null) {
					q.add(curr.right);
				}
				size--;
			}
			if (xExist && yExist) {
				return true;
			}
		}
		return false;
	}

}
