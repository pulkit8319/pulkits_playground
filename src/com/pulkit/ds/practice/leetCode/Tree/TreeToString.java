package com.pulkit.ds.practice.leetCode.Tree;

//You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
//The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.
public class TreeToString {

	public static void main(String[] args) {
		TreeNode t = new TreeNode(5);
		t.right = new TreeNode(7);
		t.left = new TreeNode(4);
		t.left.left = new TreeNode(3);
		String tree2Str = tree2str(t);
		System.out.println(tree2Str);
	}

	private static String tree2str(TreeNode t) {
		if (t == null) {
			return "";
		}
		if (t.left == null && t.right == null) {
			return t.val + "";
		}
		if (t.right == null) {
			return t.val + "(" + tree2str(t.left) + ")";
		}
		return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
	}

}
