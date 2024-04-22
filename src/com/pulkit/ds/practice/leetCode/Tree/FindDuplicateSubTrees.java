package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.
//Two trees are duplicate if they have the same structure with same node values.
public class FindDuplicateSubTrees {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(4);
		root.right.left.left = new TreeNode(4);
		List<TreeNode> list = findDuplicateSubtrees(root);
		System.out.println(list);
	}

	static List<TreeNode> list = new ArrayList<TreeNode>();

	private static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		Map<String, Integer> map = new HashMap<>();
		if (root != null) {
			duplicate(root, map);
		}
		return list;
	}

	private static String duplicate(TreeNode root, Map<String, Integer> map) {
		if (root == null) {
			return "#";
		}
		String str = root.val + ","+duplicate(root.left, map) + ","+duplicate(root.right, map);
		map.put(str, map.getOrDefault(str,0)+1);
		if(map.get(str)==2){
			list.add(root);
		}
		return str;
	}

}
