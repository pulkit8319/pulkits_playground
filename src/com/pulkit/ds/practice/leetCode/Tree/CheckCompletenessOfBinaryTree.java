package com.pulkit.ds.practice.leetCode.Tree;

import java.util.LinkedList;
import java.util.Queue;

//Given a binary tree, determine if it is a complete binary tree.
//Definition of a complete binary tree from Wikipedia:In a complete binary tree every level,except possibly the last,is completely filled,and all nodes in the last level are as far left as possible.It can have between 1 and 2 h nodes inclusive at the last level h.
public class CheckCompletenessOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(5);
		boolean isComplete = isCompleteTree(root);
		System.out.println(isComplete);
	}

	private static boolean isCompleteTree(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		boolean halfNodeFound = false;
		while (!q.isEmpty()) {
			TreeNode curr = q.poll();
			if (curr.left != null) {
				if (halfNodeFound) {
					return false;
				} else {
					q.add(curr.left);
				}
			} else {
				halfNodeFound = true;
			}
			if (curr.right != null) {
				if (halfNodeFound) {
					return false;
				} else {
					q.add(curr.right);
				}
			} else {
				halfNodeFound = true;
			}
		}
		return true;
	}

}
