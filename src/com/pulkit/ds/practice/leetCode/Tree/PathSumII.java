package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.List;

//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//Note: A leaf is a node with no children.

public class PathSumII {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(27);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(17);
		root.right.right = new TreeNode(7);
		int sum = 30;
		List<List<Integer>> paths = pathSum(root, sum);
		System.out.println(paths);
	}

	static List<List<Integer>> list = new ArrayList<>();

	private static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<Integer> lst = new ArrayList<>();
		pathSum(root, sum, lst);
		return list;
	}

	private static void pathSum(TreeNode root, int sum, List<Integer> lst) {
		if (root == null) {
			return;
		}
		lst.add(root.val);
		sum = sum - root.val;
		if (sum == 0 && root.left == null && root.right == null) {
			list.add(new ArrayList(lst));
			lst.remove(lst.size() - 1);
			return;
		}
		pathSum(root.left, sum, lst);
		pathSum(root.right, sum, lst);
		lst.remove(lst.size()-1);
	}

}
