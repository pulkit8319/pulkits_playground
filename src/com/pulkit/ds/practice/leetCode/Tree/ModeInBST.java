package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
public class ModeInBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(2);
		int arr[] = findModeRecursive(root);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}

	static int count = 1, maxCount = 0;
	static Integer prev = null;

	private static int[] findModeRecursive(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		inorder(root, list);
		int[] arr = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}

	private static void inorder(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		inorder(root.left, list);
		if (prev != null) {
			if (prev == root.val) {
				count++;
			} else {
				count = 1;
			}
		}
		if (count > maxCount) {
			maxCount = count;
			list.clear();
			list.add(root.val);
		} else if (maxCount == count) {
			list.add(root.val);
		}
		prev = root.val;
		inorder(root.right, list);
	}

	private static int[] findModeIterative(TreeNode root) {
		if (root == null) {
			return new int[0];
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		int maxCount = 0;
		Map<Integer, Integer> map = new HashMap<>();
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (map.containsKey(node.val)) {
				map.put(node.val, map.get(node.val) + 1);
			} else {
				map.put(node.val, 1);
			}
			int count = map.get(node.val);
			if (count > maxCount) {
				maxCount = count;
			}
			if (node.left != null) {
				q.offer(node.left);
			}
			if (node.right != null) {
				q.offer(node.right);
			}
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int key : map.keySet()) {
			if (map.get(key) == maxCount) {
				list.add(key);
			}
		}
		int arr[] = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}

}
