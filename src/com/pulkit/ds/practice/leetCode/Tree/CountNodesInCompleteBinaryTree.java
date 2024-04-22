package com.pulkit.ds.practice.leetCode.Tree;

import java.util.LinkedList;
import java.util.Queue;

//Given a complete binary tree, count the number of nodes.
//Note:
//Definition of a complete binary tree from Wikipedia:In a complete binary tree every level,except possibly the last,is completely filled,and all nodes in the last level are as far left as possible.It can have between 1 and 2 h nodes inclusive at the last level h.

public class CountNodesInCompleteBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(5);

		int count = countNodes(root);
		System.out.println(count);
	}

	private static int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int height = height(root);
		int nodesTill2ndLastLevel = (int) Math.pow(2, height - 1) - 1;
		int nodesAtLastLevel = getLastLevelNodes(root, height);
		return nodesTill2ndLastLevel + nodesAtLastLevel;
	}

	private static int getLastLevelNodes(TreeNode root, int height) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int level = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			level++;
			if (level == height) {
				return size;
			}
			while (size > 0) {
				TreeNode curr = q.poll();
				if (curr.left != null) {
					q.add(curr.left);
				}
				if (curr.right != null) {
					q.add(curr.right);
				}
				size--;
			}
		}
		return 0;
	}

	private static int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(height(root.left), height(root.right)) + 1;
	}

}
