package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.List;

//Given a n-ary tree, find its maximum depth.
//The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

public class DepthOfN_AryTree {

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
		int depth = maxDepth(root);
		System.out.println(depth);
	}

	private static int maxDepth(NAryNode root) {
		if (root == null) {
			return 0;
		}
		int maxDepth = 0;
		if (root.children != null) {
			for (NAryNode n : root.children) {
				maxDepth = Math.max(maxDepth, maxDepth(n));
			}
		}
		return maxDepth + 1;
	}

}

