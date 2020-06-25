package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.List;

//Given a binary tree with N nodes, each node has a different value from {1, ..., N}.
//A node in this binary tree can be flipped by swapping the left child and the right child of that node.
//Consider the sequence of N values reported by a preorder traversal starting from the root.  Call such a sequence of N values the voyage of the tree.
//(Recall that a preorder traversal of a node means we report the current node's value, then preorder-traverse the left child, then preorder-traverse the right child.)
//Our goal is to flip the least number of nodes in the tree so that the voyage of the tree matches the voyage we are given.
//If we can do so, then return a list of the values of all nodes flipped.  You may return the answer in any order.
//If we cannot do so, then return the list [-1].
public class FlipBinaryTreeToMatchPreOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		int[] voyage = { 1, 2, 3 };
		List<Integer> list = flipMatchVoyage(root, voyage);
		System.out.println(list);
	}

	static List<Integer> list = new ArrayList<Integer>();
	static int index = 0;
	private static List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
		boolean can = flipMatchVoyage1(root, voyage);
		if (!can) {
			list.clear();
			list.add(-1);
		}
		return list;
	}

	private static boolean flipMatchVoyage1(TreeNode root, int[] voyage) {
		if (root == null) {
			return true;
		}
		if (root.val != voyage[index++]) {
			return false;
		}
		if(root.left!=null && root.left.val!=voyage[index]){
			list.add(root.val);
			return flipMatchVoyage1(root.right, voyage) && flipMatchVoyage1(root.left, voyage);
		}
		return flipMatchVoyage1(root.left, voyage) && flipMatchVoyage1(root.right, voyage);
	}

}
