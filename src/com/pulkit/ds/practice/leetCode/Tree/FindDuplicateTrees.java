package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.
//Two trees are duplicate if they have the same structure with same node values.

public class FindDuplicateTrees {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.right = new TreeNode(7);
		root.left = new TreeNode(4);
		List<TreeNode> list = findDuplicateSubtrees(root);
		System.out.println(list);
	}

	static List<TreeNode> list = new ArrayList<TreeNode>();
	private static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		Map<String, TreeNode> map = new HashMap<>();
		findDuplicateSubtrees(list, map, root, "");
		return list;
	}

	private static void findDuplicateSubtrees(List<TreeNode> list, Map<String, TreeNode> map, TreeNode root,
			String string) {
		if (root == null) {
			return;
		}
		findDuplicateSubtrees(list, map, root.left, string);
		string += root.val + "->";
		if (map.containsKey(string)) {
			list.add(map.get(string));
		}else{
			map.put(string, root);
		}
		findDuplicateSubtrees(list, map, root.right, string);
	}

}
