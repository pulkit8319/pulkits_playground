package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

//Given a binary tree, return the vertical order traversal of its nodes values.
//For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).
//Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).
//If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
//Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.
public class VerticalOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.left.right = new TreeNode(8);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(9);
		List<List<Integer>> list = verticalTraversal(root);
		System.out.println(list);
	}

	static Map<Integer, List<Integer>> map = new TreeMap<>();
//This might give order not same as that appear in tree.
	private static List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root != null) {
			verticalTraversal(0, root);
			System.out.println(map);
			list = map.values().stream().collect(Collectors.toList());
		}
		return list;
	}

	private static void verticalTraversal(int i, TreeNode root) {
		if (root == null) {
			return;
		}
		if (map.containsKey(i)) {
			map.get(i).add(root.val);
		} else {
			map.put(i, new ArrayList<>(Arrays.asList(root.val)));
		}
		verticalTraversal(i-1,root.left);
		verticalTraversal(i+1,root.right);
	}

}
