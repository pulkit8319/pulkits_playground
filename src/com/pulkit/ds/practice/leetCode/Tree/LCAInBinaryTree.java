package com.pulkit.ds.practice.leetCode.Tree;

//Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
//According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
public class LCAInBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(21);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(15);

		TreeNode p = new TreeNode(7);
		TreeNode q = new TreeNode(21);
		TreeNode node = lowestCommonAncestor(root, p, q);
		System.out.println(node.val);
	}

	private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null) {
			return null;
		}
		if (root.val == p.val || root.val == q.val) {
			return root;
		}
		TreeNode left_lca = lowestCommonAncestor(root.left, p, q);
		TreeNode right_lca = lowestCommonAncestor(root.right, p, q);
		if (null != left_lca && null != right_lca) {
			return root;
		}
		return left_lca != null ? left_lca : right_lca;

	}

}
