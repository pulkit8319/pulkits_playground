package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.List;

//Given a n-ary tree, find its maximum depth.
//The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

public class MinDiffInBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.right = new TreeNode(7);
		root.left = new TreeNode(4);
		int minDiff = minDiffInBST(root);
		System.out.println(minDiff);
	}

	static int diff = Integer.MAX_VALUE;
	static Integer prev;

	private static int minDiffInBST(TreeNode root) {
		if (root == null) {
			return diff;
		}
		minDiffInBST(root.left);
		if (null != prev) {
			int val = Math.abs(root.val-prev);
			if(val<diff){
				diff = val;
			}
		}
		prev = root.val;
		minDiffInBST(root.right);
		return diff;
	}

	private static int minDiffInBSTIterative(TreeNode root) {
		int diff = Integer.MAX_VALUE;
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return diff;
		}
		inorder(root, list);
		for (int i = 0; i < list.size() - 1; i++) {
			int val = list.get(i + 1) - list.get(i);
			if (val < diff) {
				diff = val;
			}
		}
		return diff;
	}

	private static void inorder(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		inorder(root.left, list);
		list.add(root.val);
		inorder(root.right, list);
	}

}
