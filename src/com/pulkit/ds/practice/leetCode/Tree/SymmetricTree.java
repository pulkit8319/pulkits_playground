package com.pulkit.ds.practice.leetCode.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.right.right = new TreeNode(3);

		boolean isSymmetric = isSymmetricIterative(root);
		System.out.println(isSymmetric);
	}

	private static boolean isSymmetricRecursive(TreeNode root) {
		return isMirror(root, root);
	}
	
	private static boolean isSymmetricIterative(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode node1 = queue.poll();
			TreeNode node2 = queue.poll();
			if (node1 == null && node2 == null) {
				continue;
			}
			if (node1 == null || node2 == null) {
				return false;
			}
			if (node1.val != node2.val) {
				return false;
			}
			queue.add(node1.left);
			queue.add(node2.right);
			queue.add(node1.right);
			queue.add(node2.left);
		}
		return true;
	}

	private static boolean isMirror(TreeNode root, TreeNode root2) {
		if (root == null && root2 == null) {
			return true;
		}
		if (root == null || root2 == null) {
			return false;
		}
		if (root.val != root2.val) {
			return false;
		}
		return isMirror(root.left, root2.right) && isMirror(root.right, root2.left);
	}

}
