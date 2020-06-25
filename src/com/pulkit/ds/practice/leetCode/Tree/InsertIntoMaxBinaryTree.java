package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.List;

//We are given the root node of a maximum tree: a tree where every node has a value greater than any other value in its subtree.
//Just as in the previous problem, the given tree was constructed from an list A (root = Construct(A)) recursively with the following Construct(A) routine:
//If A is empty, return null.
//Otherwise, let A[i] be the largest element of A.  Create a root node with value A[i].
//The left child of root will be Construct([A[0], A[1], ..., A[i-1]])
//The right child of root will be Construct([A[i+1], A[i+2], ..., A[A.length - 1]])
//Return root.
//Note that we were not given A directly, only a root node root = Construct(A).
//Suppose B is a copy of A with the value val appended to it.  It is guaranteed that B has unique values.
//Return Construct(B).

public class InsertIntoMaxBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.right = new TreeNode(7);
		root.left = new TreeNode(4);
		int val = 5;
		TreeNode node = insertIntoMaxTreeIterative(root, val);
		System.out.println(node.val);
	}

	private static TreeNode insertIntoMaxTreeIterative(TreeNode root, int val) {
		TreeNode newNode = new TreeNode(val);
		if (root == null) {
			return newNode;
		}
		TreeNode node = root;
		TreeNode prev = null;
		while (node != null && val < node.val) {
			prev = node;
			node = node.right;
		}
		newNode.left = node;
		if (prev != null) {
			prev.right = newNode;
		}else{
			return newNode;
		}
		return root;
	}

	private static TreeNode insertIntoMaxTree(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		if (val > root.val) {
			TreeNode node = new TreeNode(val);
			node.left = root;
			return node;
		}
		root.right = insertIntoMaxTree(root.right, val);
		return root;
	}

}
