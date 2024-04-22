package com.pulkit.ds.practice.leetCode.Tree;

import java.util.HashMap;
import java.util.Map;

//Return any binary tree that matches the given preorder and postorder traversals.
//Values in the traversals pre and post are distinct positive integers.
public class BinaryTreeFromPreOrderAndPostOrder {

	public static void main(String[] args) {
		int[] pre = { 1, 2, 4, 5, 3, 6, 7 };
		int[] post = { 4, 5, 2, 6, 7, 3, 1 };
		TreeNode node = buildTree(pre, post);
		node.inOrder(node);
	}

	private static TreeNode buildTree(int[] pre, int[] post) {
		if (pre.length == 0 || post.length == 0) {
			return null;
		}
		Map<Integer, Integer> map = new HashMap();
		for (int i = 0; i < post.length; i++) {
			map.put(post[i], i);
		}
		return buildTree(0, post.length - 1, pre, post, map);
	}

	static int preIndex = 0;

	private static TreeNode buildTree(int start, int end, int[] pre, int[] post, Map<Integer, Integer> map) {
		if (start > end) {
			return null;
		}
		int val = pre[preIndex++];
		TreeNode root = new TreeNode(val);
		if (start == end) {
			return root;
		}
		int leftVal = pre[preIndex];
		Integer index = map.get(leftVal);
		root.left = buildTree(start, index, pre, post, map);
		root.right = buildTree(index + 1, end-1, pre, post, map);
		return root;
	}

}
