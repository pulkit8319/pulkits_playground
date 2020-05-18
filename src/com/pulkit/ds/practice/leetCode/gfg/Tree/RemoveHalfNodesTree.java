package com.pulkit.ds.practice.leetCode.gfg.Tree;

public class RemoveHalfNodesTree {

	public static void main(String[] args) {
		Node root = new Node(2);
		root.left = new Node(7);
		root.right = new Node(5);
		root.left.right = new Node(6);
		root.left.right.left = new Node(1);
		root.left.right.right = new Node(11);
		root.right.right = new Node(9);
		root.right.right.left = new Node(4);
		root.right.right.left.right = new Node(10);

		/*
		 * Node root = new Node(2); root.left = new Node(1); root.right = new
		 * Node(3); root.left.left = new Node(4); root.left.right = new Node(6);
		 * root.right.right = new Node(8); root.left.right.left = new Node(5);
		 */
		// root.inorder(root);
		Node node = removeHalfNodes(root);
		node.inorder(root);
	}

	private static Node removeHalfNodes(Node root) {
		if (root == null) {
			return null;
		}
		root.left = removeHalfNodes(root.left);
		root.right = removeHalfNodes(root.right);
		if (root.left == null && root.right != null) {
			return root.right;
		} else if (root.left != null && root.right == null) {
			return root.left;
		}
		return root;
	}

}
