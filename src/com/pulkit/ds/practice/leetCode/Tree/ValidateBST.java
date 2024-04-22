package com.pulkit.ds.practice.leetCode.Tree;

import java.util.Stack;

//Given a binary tree, determine if it is a valid binary search tree (BST).

public class ValidateBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(4);
		root.right = new TreeNode(3);

		boolean isValid = isValidBSTOptimised(root,null,null);
		System.out.println(isValid);
	}

	private static boolean isValidBSTOptimised(TreeNode root,TreeNode max,TreeNode min) {
		if(root==null){
			return true;
		}
		if(min!=null && root.val<min.val){
			return false;
		}
		if(max!=null && root.val>max.val){
			return false;
		}
		return isValidBSTOptimised(root.left, root, max) && isValidBSTOptimised(root.right, max, root);
	}

	private static boolean isValidBSTIterative(TreeNode root) {
		if(root==null){
			return true;
		}
		Stack<TreeNode> stk = new Stack<TreeNode>();
		TreeNode curr = root;
		TreeNode pre = null;
		while(curr!=null){
			stk.push(curr);
			curr = curr.left;
			while(curr==null && !stk.isEmpty()){
				curr = stk.pop();
				if(null!=pre && pre.val>=curr.val){
					return false;
				}
				pre = curr;
				curr = curr.right;
			}
		}
		return true;
	}

	static Integer prev;

	private static boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		boolean left = isValidBST(root.left);
		if (prev != null && prev > root.val) {
			return false;
		}
		prev = root.val;
		boolean right = isValidBST(root.right);
		return left && right;
	}
}
