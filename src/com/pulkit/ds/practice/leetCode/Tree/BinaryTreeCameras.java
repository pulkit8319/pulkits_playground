package com.pulkit.ds.practice.leetCode.Tree;

import java.util.HashSet;
import java.util.Set;

//Given a binary tree, we install cameras on the nodes of the tree. 
//Each camera at a node can monitor its parent,itself,and its immediate children.
//Calculate the minimum number of cameras needed to monitor all nodes of the tree.

public class BinaryTreeCameras {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		int num = minCameraCover(root);
		System.out.println(num);
	}

	static int ans = 0;
	static Set<TreeNode> set = new HashSet<>();

	private static int minCameraCover(TreeNode root) {
		set.add(null);
		dfs(root, null);
		return ans;
	}

	private static void dfs(TreeNode node, TreeNode parent) {
		if (node != null) {
			dfs(node.left, node);
			dfs(node.right, node);
			if (parent == null && !set.contains(node) || !set.contains(node.left) || !set.contains(node.right)) {
				ans++;
				set.add(node);
				set.add(parent);
				set.add(node.left);
				set.add(node.right);
			}
		}
	}

}
