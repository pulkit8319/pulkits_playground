package com.pulkit.ds.practice.leetCode.Tree;

import java.util.HashSet;
import java.util.Set;

//Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.
//Given such a binary tree,you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
//If no such second minimum value exists,output-1 instead.

public class SecondMinimumTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		//root.right.left = new TreeNode(2);
		//root.right.right = new TreeNode(2);
		int secondMin = findSecondMinimumValueIterative(root);
		System.out.println(secondMin);
	}

	private static int findSecondMinimumValueIterative(TreeNode root) {
		Set<Integer> set = new HashSet<Integer>();
		populate(root, set);
		int val = root.val;
		long min = Long.MAX_VALUE;
		for(Integer i : set){
			if(i<min && i>val){
				min = i;
			}
		}
		return min<Long.MAX_VALUE?(int)min:-1;
	}

	private static void populate(TreeNode root, Set<Integer> set) {
		if(root==null){
			return;
		}
		set.add(root.val);
		populate(root.left, set);
		populate(root.right, set);
	}

	static int min;
	static long ans = Long.MAX_VALUE;

	private static int findSecondMinimumValue(TreeNode root) {
		min = root.val;
		dfs(root);
		return ans < Long.MAX_VALUE ? (int) ans : -1;
	}

	private static void dfs(TreeNode root) {
		if (root != null) {
			if (min < root.val && root.val < ans) {
				ans = root.val;
			} else if (min == root.val) {
				dfs(root.left);
				dfs(root.right);
			}
		}
	}

}
