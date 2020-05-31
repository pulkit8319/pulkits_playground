package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Given the root of a binary tree, each node in the tree has a distinct value.
//After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
//Return the roots of the trees in the remaining forest.  You may return the result in any order.

public class DeleteAndReturnForest {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		int to_delete[] = { 1, 3, 5 };
		List<TreeNode> list = delNodes(root, to_delete);
		System.out.println(list);
	}


	private static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		List<TreeNode> forest = new ArrayList<TreeNode>();
		if (root == null) {
			return forest;
		}
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < to_delete.length; i++) {
			set.add(to_delete[i]);
		}
		delNodes(root, set,forest);
		if (!set.contains(root.val)) {
			forest.add(root);
		}
		return forest;
	}

	private static TreeNode delNodes(TreeNode root, Set<Integer> set, List<TreeNode> forest) {
		if (root == null) {
			return null;
		}
		root.left = delNodes(root.left, set,forest);
		root.right = delNodes(root.right, set,forest);
		if (set.contains(root.val)) {
			if (root.left != null) {
				forest.add(root.left);
			}
			if (root.right != null) {
				forest.add(root.right);
			}
			root = null;
		}
		return root;
	}
}
