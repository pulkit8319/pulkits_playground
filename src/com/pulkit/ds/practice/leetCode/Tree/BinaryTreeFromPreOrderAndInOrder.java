package com.pulkit.ds.practice.leetCode.Tree;

import java.util.HashMap;
import java.util.Map;

//Given preorder and inorder traversal of a tree, construct the binary tree.
//Note:
//You may assume that duplicates do not exist in the tree.
public class BinaryTreeFromPreOrderAndInOrder {

	public static void main(String[] args) {
		int[] preorder = { 1, 2 };
		int[] inorder = { 2, 1 };
		TreeNode node = buildTree(preorder, inorder);
		node.inOrder(node);
	}

	private static TreeNode buildTree(int[] preorder, int[] inorder) {
		if (inorder.length == 0 || preorder.length == 0) {
			return null;
		}
		Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			inMap.put(inorder[i], i);
		}
		return buildTree(0, inorder.length - 1, preorder, inorder, inMap);
	}

	static int pindex = 0;

	private static TreeNode buildTree(int start, int end, int[] preorder, int[] inorder, Map<Integer, Integer> inMap) {
		if (start > end) {
			return null;
		}
		int val = preorder[pindex++];
		TreeNode root = new TreeNode(val);
		if (start == end) {
			return root;
		}
		int index = inMap.get(val);// or use for loop to get index
		root.left = buildTree(start, index - 1, preorder, inorder, inMap);
		root.right = buildTree(index + 1, end, preorder, inorder, inMap);
		return root;
	}

}
