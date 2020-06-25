package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//We are given a binary tree (with root node root), a target node, and an integer value K.
//Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
public class AllNodesAtDistanceKInBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(7);
		root.left.right.left = new TreeNode(4);
		TreeNode target = root.left;
		List<Integer> list = distanceK(root, target, 2);
		System.out.println(list);
	}

	static Map<TreeNode, Integer> map = new HashMap<>();

	private static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		List<Integer> list = new ArrayList<Integer>();
		if (root != null) {
			find(root, target);
			search(root, 0, k, list);
		}
		return list;
	}

	private static void search(TreeNode root, int dis, int k, List<Integer> list) {
		if (root == null) {
			return;
		}
		if (map.containsKey(root)) {
			dis = map.get(root);
		}
		if (dis == k) {
			list.add(root.val);
		}
		search(root.left, dis + 1, k, list);
		search(root.right, dis + 1, k, list);
	}

	private static void find(TreeNode node, TreeNode target) {
		if (node == null) {
			return;
		}
		if (node == target) {
			map.put(target, 0);
			return;
		}
		find(node.left, target);
		if (map.containsKey(node.left)) {
			map.put(node, map.get(node.left) + 1);
			return;
		}
		find(node.right, target);
		if (map.containsKey(node.right)) {
			map.put(node, map.get(node.right) + 1);
			return;
		}
		return;
	}

}
