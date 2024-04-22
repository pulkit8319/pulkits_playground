package com.pulkit.ds.practice.leetCode.Tree;

//Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
public class SubTreeOfAnotherTree {

	public static void main(String[] args) {
		TreeNode s = new TreeNode(3);
		s.right = new TreeNode(5);
		s.left = new TreeNode(4);
		s.left.left = new TreeNode(1);
		s.left.right = new TreeNode(2);

		TreeNode t = new TreeNode(4);
		t.left = new TreeNode(1);
		t.right = new TreeNode(2);
		boolean isSubtree = isSubtree(s, t);
		System.out.println(isSubtree);
	}

	private static boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null) {
			return t == null;
		}
		if (isSame(s, t)) {
			return true;
		}

		return isSubtree(s.left, t) || isSubtree(s.right, t);
	}

	private static boolean isSame(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		}
		if (s == null || t == null) {
			return false;
		}
		return (s.val == t.val) && isSame(s.left, t.left) && isSame(s.right, t.right);
	}

}
