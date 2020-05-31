package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

public class KthSmallestElementInABST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
		int k = 1;
		int kthElement = kthSmallest(root, k);
		System.out.println(kthElement);
	}

	private static int kthSmallest(TreeNode root, int k) {
		List<Integer> list = new ArrayList<>();
		inorder(root,list);
		return list.get(k-1);
	}

	private static void inorder(TreeNode root, List<Integer> list) {
		if(root==null){
			return;
		}
		inorder(root.left, list);
		list.add(root.val);
		inorder(root.right, list);
	}

	private static int kthSmallestIterative(TreeNode root, int k) {
		if (root == null) {
			return -1;
		}
		int num = -1;
		Stack<TreeNode> stk = new Stack<>();
		TreeNode curr = root;
		while (curr != null) {
			stk.add(curr);
			curr = curr.left;
			while (curr == null && !stk.isEmpty()) {
				curr = stk.pop();
				k--;
				if (k == 0) {
					return curr.val;
				}
				curr = curr.right;
			}
		}
		return num;
	}

}
