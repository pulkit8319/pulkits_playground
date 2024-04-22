package com.pulkit.ds.practice.leetCode.Tree;

import java.util.LinkedList;
import java.util.Queue;

//Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
public class FindBottomLeftValue {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(3);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(3);

		int num = findBottomLeftValue(root);
		System.out.println(num);
	}

	static int ans, h;

	private static int findBottomLeftValue(TreeNode root) {
		lot(root, 1);
		return ans;
	}

	private static void lot(TreeNode root, int level) {
		if (root != null) {
			if (h < level) {
				ans = root.val;
				h = level;
			}
			lot(root.left, level + 1);
			lot(root.right, level + 1);
		}
	}

	private static int findBottomLeftValueIterative(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int height = height(root);
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			while (size > 0) {
				TreeNode curr = q.poll();
				if (height == 1) {
					return curr.val;
				}
				if (curr.left != null) {
					q.add(curr.left);
				}
				if (curr.right != null) {
					q.add(curr.right);
				}
				size--;
			}
			height--;
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
