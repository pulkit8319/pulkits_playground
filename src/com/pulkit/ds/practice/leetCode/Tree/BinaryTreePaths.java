package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.List;

//Given a binary tree, return all root-to-leaf paths.
public class BinaryTreePaths {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(17);
		root.right.right = new TreeNode(7);
		List<String> list = binaryTreePaths(root);
		System.out.println(list);
	}

	private static List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<String>();
		if (root != null) {
			bTP(root, "", list);
		}
		return list;
	}

	private static List<String> bTP(TreeNode root, String sb, List<String> list) {
		int val = root.val;
		if (root.left == null && root.right == null) {
			list.add(sb + val);
		}
		if (root.left != null) {
			bTP(root.left, sb + val + "->", list);
		}
		if (root.right != null) {
			bTP(root.right, sb + val + "->", list);
		}
		return list;
	}

}
