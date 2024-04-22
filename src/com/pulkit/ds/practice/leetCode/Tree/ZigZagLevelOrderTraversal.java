package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

//Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

public class ZigZagLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(7);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(11);
		List<List<Integer>> list = zigzagLevelOrderIterative(root);
		System.out.println(list);
	}

	private static List<List<Integer>> zigzagLevelOrderIterative(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		boolean reverse = false;
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> lst = new ArrayList<>();
			while (size > 0) {
				TreeNode curr = q.poll();
					lst.add(curr.val);
				if (curr.left != null) {
					q.add(curr.left);
				}
				if (curr.right != null) {
					q.add(curr.right);
				}
				size--;
			}
			if(reverse){
				Collections.reverse(lst);
			}
			list.add(lst);
			reverse = !reverse;
		}
		return list;
	}

	private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		return zigzagLevelOrder(root, list, 0);
	}

	private static List<List<Integer>> zigzagLevelOrder(TreeNode root, List<List<Integer>> list, int level) {
		if (root == null) {
			return list;
		}
		if (level == list.size()) {
			List<Integer> lst = new ArrayList<>();
			lst.add(root.val);
			list.add(lst);
		} else {
			if (level % 2 == 1) {
				list.get(level).add(0, root.val);
			} else {
				list.get(level).add(root.val);
			}
		}
		zigzagLevelOrder(root.left, list, level + 1);
		zigzagLevelOrder(root.right, list, level + 1);
		return list;
	}

}
