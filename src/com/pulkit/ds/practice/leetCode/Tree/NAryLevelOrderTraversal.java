package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Given an n-ary tree, return the postorder traversal of its nodes' values.
//Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
public class NAryLevelOrderTraversal {

	public static void main(String[] args) {
		NAryNode root = new NAryNode(1);
		NAryNode node1 = new NAryNode(3);
		NAryNode node2 = new NAryNode(2);
		NAryNode node3 = new NAryNode(4);
		NAryNode node4 = new NAryNode(5);
		NAryNode node5 = new NAryNode(6);
		List<NAryNode> list1 = new ArrayList<>();
		list1.add(node1);
		list1.add(node2);
		list1.add(node3);
		root.children = list1;
		List<NAryNode> list2 = new ArrayList<>();
		list2.add(node4);
		list2.add(node5);
		node1.children = list2;
		List<List<Integer>> list = levelorder(root);
		System.out.println(list);
	}

	static List<List<Integer>> list = new ArrayList<>();

	private static List<List<Integer>> levelorder(NAryNode root) {
		levelorder(root, 0);
		return list;
	}

	private static void levelorder(NAryNode root, int level) {
		if (root == null) {
			return;
		}
		if (level == list.size()) {
			List<Integer> lst = new ArrayList<>();
			lst.add(root.val);
			list.add(lst);
		} else {
			list.get(level).add(root.val);
		}
		if (root.children != null) {
			for (NAryNode node : root.children) {
				levelorder(node,level+1);
			}
		}
	}

	private static List<List<Integer>> levelorderIterative(NAryNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Queue<NAryNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> lst = new ArrayList<>();
			while (size > 0) {
				NAryNode poll = q.poll();
				lst.add(poll.val);
				if (null != poll.children) {
					q.addAll(poll.children);
				}
				size--;
			}
			list.add(lst);
		}
		return list;
	}

}
