package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.List;

//Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?


//High complexity. Use DP to solve.
public class UniqueBinarySearchTrees {
	public static void main(String[] args) {
		int num = numTrees(3);
		System.out.println(num);
	}

	private static int numTrees(int n) {
		List<TreeNode> list = numTrees(1, n);
		return list.size();
	}

	private static List<TreeNode> numTrees(int start, int end) {
		List<TreeNode> trees = new ArrayList<TreeNode>();
		if (start > end) {
			trees.add(null);
			return trees;
		}
		for (int i = start; i <= end; i++) {
			List<TreeNode> lefts = numTrees(start, i - 1);
			List<TreeNode> rights = numTrees(i + 1, end);
			for (TreeNode left : lefts) {
				for (TreeNode right : rights) {
					TreeNode root = new TreeNode(start);
					root.left = left;
					root.right = right;
					trees.add(root);
				}
			}
		}
		return trees;
	}

}
