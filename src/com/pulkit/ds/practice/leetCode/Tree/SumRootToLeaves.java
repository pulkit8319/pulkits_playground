package com.pulkit.ds.practice.leetCode.Tree;

import java.util.Stack;

//Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
//An example is the root-to-leaf path 1->2->3 which represents the number 123.
//Find the total sum of all root-to-leaf numbers.
public class SumRootToLeaves {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		int sum = sumNumbersIterative(root);
		System.out.println(sum);

	}

	private static int sumNumbersIterative(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int sum = 0;
		Stack<TreeNode> stk = new Stack<TreeNode>();
		stk.push(root);
		while (!stk.isEmpty()) {
			TreeNode curr = stk.pop();
			if (curr.left != null) {
				curr.left.val = curr.val * 10 + curr.left.val;
				stk.push(curr.left);
			}
			if (curr.right != null) {
				curr.right.val = curr.val * 10 + curr.right.val;
				stk.push(curr.right);
			}
			if (curr.left == null && curr.right == null) {
				sum += curr.val;
			}
		}
		return sum;
	}

	static int sum = 0;

	private static int sumNumbers(TreeNode root) {
		int num = 0;
		sumNumbers(root, num);
		return sum;
	}

	private static void sumNumbers(TreeNode root, int num) {
		if (root == null) {
			return;
		}
		num += root.val;
		if (root.left == null && root.right == null) {
			sum += num;
		}
		sumNumbers(root.left, num * 10);
		sumNumbers(root.right, num * 10);
	}

}
