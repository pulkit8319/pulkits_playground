package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.List;

//Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be pseudo-palindromic if at least one permutation of the node values in the path is a palindrome.
//Return the number of pseudo-palindromic paths going from the root node to leaf nodes
public class PseudoPalindromeInABinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);
		root.right.right = new TreeNode(1);

		int count = pseudoPalindromicPaths(root);
		System.out.println(count);
	}

	private static int pseudoPalindromicPaths(TreeNode root) {
		// return pseudoPalindromicPaths(root, new ArrayList<Integer>());
		// return pseudoPalindromicPaths(root, new int[10]);
		return pseudoPalindromicPathsUsingBitManipulation(root, 0);
	}

	private static int pseudoPalindromicPathsUsingBitManipulation(TreeNode root, int num) {
		if (root == null) {
			return 0;
		}
		num ^= 1 << (root.val - 1);
		if (root.left == null && root.right == null) {
			if ((num & (num - 1)) == 0) {
				return 1;
			} else {
				return 0;
			}
		}
		return pseudoPalindromicPathsUsingBitManipulation(root.left, num)
				+ pseudoPalindromicPathsUsingBitManipulation(root.right, num);
	}

	private static int pseudoPalindromicPaths(TreeNode root, int[] arr) {

		if (root == null) {
			return 0;
		}
		arr[root.val]++;
		if (root.left == null && root.right == null) {
			return checkPalindrome(arr) ? 1 : 0;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		return pseudoPalindromicPaths(root.left, arr) + pseudoPalindromicPaths(root.right, arr);
	}

	private static boolean checkPalindrome(int[] arr) {
		int miss = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0) {
				miss++;
			}
			if (miss > 1) {
				return false;
			}
		}
		return false;
	}

	private static int pseudoPalindromicPaths(TreeNode root, List<Integer> list) {
		if (root == null) {
			return 0;
		}
		if (list.contains(root.val)) {
			list.remove((Integer) root.val);
		} else {
			list.add(root.val);
		}
		if (root.left == null && root.right == null) {
			int size = list.size();
			if (size == 0 || size == 1) {
				return 1;
			} else {
				return 0;
			}
		}
		return pseudoPalindromicPaths(root.left, new ArrayList(list))
				+ pseudoPalindromicPaths(root.right, new ArrayList(list));

	}

}
