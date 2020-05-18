package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.List;

//Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
public class TwoNumSumEqualToTarget {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(7);
		int k = 12;
		boolean exists = findTargetIterative(root, k);
		System.out.println(exists);
	}

	private static boolean findTargetIterative(TreeNode root, int k) {//2,3,4,5,6,7
		List<Integer> list = new ArrayList<>();
		inorder(root, list);
		int l = 0, r = list.size() - 1;
		while (l < r) {
			int left = list.get(l);
			int right = list.get(r);
			if (left + right > k) {
				r--;
			} else if (left + right < k) {
				l++;
			} else {
				return true;
			}
		}
		return false;
	}

	private static void inorder(TreeNode root, List<Integer> list2) {
		if (root == null) {
			return;
		}
		inorder(root.left, list2);
		list2.add(root.val);
		inorder(root.right, list2);
	}

	static List<Integer> list = new ArrayList<Integer>();

	private static boolean findTarget(TreeNode root, int k) {
		if (root == null) {
			return false;
		}
		if (list.contains(root.val)) {
			return true;
		}
		list.add(k - root.val);
		return findTarget(root.left, k) || findTarget(root.right, k);
	}

}
