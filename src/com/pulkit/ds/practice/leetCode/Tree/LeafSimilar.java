package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.List;

//Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
//For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
//Two binary trees are considered leaf-similar if their leaf value sequence is the same.
//Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
public class LeafSimilar {

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(3);
		root1.left = new TreeNode(9);
		root1.right = new TreeNode(20);
		root1.right.left = new TreeNode(15);
		root1.right.right = new TreeNode(7);

		TreeNode root2 = new TreeNode(3);
		root2.left = new TreeNode(9);
		root2.right = new TreeNode(20);
		root2.right.left = new TreeNode(15);
		root2.right.right = new TreeNode(7);

		boolean isLeafSimilar = leafSimilar(root1, root2);
		System.out.println(isLeafSimilar);
	}

	private static boolean leafSimilar(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null) {
			return false;
		}
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		similar(root1,list1);
		similar(root2,list2);
		return list1.equals(list2);
	}

	private static void similar(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		similar(root.left,list);
		if (root.left == null && root.right == null) {
			list.add(root.val);
		}
		similar(root.right,list);
	}

}
