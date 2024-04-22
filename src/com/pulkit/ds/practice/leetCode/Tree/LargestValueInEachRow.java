package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//You need to find the largest value in each row of a binary tree.

public class LargestValueInEachRow {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(1);

		List<Integer> list = largestValues(root);
		System.out.println(list);
	}

	static List<Integer> list = new ArrayList<Integer>();

	private static List<Integer> largestValues(TreeNode root) {
		largestValues(root, 0);
		return list;
	}

	private static void largestValues(TreeNode root, int level) {
		if (root == null) {
			return;
		}
		if (level == list.size()) {
			list.add(root.val);
		} else {
			list.set(level, Math.max(list.get(level), root.val));
		}
		largestValues(root.left, level + 1);
		largestValues(root.right, level + 1);
	}

	private static List<Integer> largestValuesIterative(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			int max = Integer.MIN_VALUE;
			while (size > 0) {
				TreeNode curr = q.poll();
				max = Math.max(max, curr.val);
				if (curr.left != null) {
					q.add(curr.left);
				}
				if (curr.right != null) {
					q.add(curr.right);
				}
				size--;
			}
			list.add(max);
		}
		return list;
	}

}
