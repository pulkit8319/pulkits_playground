package com.pulkit.ds.practice.leetCode.Tree;

import java.util.HashMap;
import java.util.Map;

//Given inorder and postorder traversal of a tree, construct the binary tree.
//Note:
//You may assume that duplicates do not exist in the tree.
public class BinaryTreeFromPostOrderAndInOrder {

	public static void main(String[] args) {
		int[] inorder = { 9, 3, 15, 20, 7 };
		int[] postorder = { 9, 15, 7, 20, 3 };
		TreeNode node = buildTree(inorder, postorder);
		node.inOrder(node);
	}

	private static TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length == 0 || postorder.length == 0) {
			return null;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return buildTree(0, inorder.length - 1, inorder, postorder, map,postorder.length-1);
	}

	static int postOrderIndex = 0;

	private static TreeNode buildTree(int start, int end, int[] inorder, int[] postorder, Map<Integer, Integer> map, int postOrderlength) {
		if (start > end) {
			return null;
		}
		int val = postorder[postOrderlength - postOrderIndex++];
		TreeNode node = new TreeNode(val);
		if (start == end) {
			return node;
		}
		Integer index = map.get(val);
		node.right = buildTree(index + 1, end, inorder, postorder, map,postOrderlength);
		node.left = buildTree(start, index - 1, inorder, postorder, map,postOrderlength);
		return node;
	}

}
