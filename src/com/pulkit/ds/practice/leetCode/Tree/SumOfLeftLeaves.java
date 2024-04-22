package com.pulkit.ds.practice.leetCode.Tree;

import java.util.Stack;

//Find the sum of all left leaves in a given binary tree.
public class SumOfLeftLeaves {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(17);
		root.right.right = new TreeNode(7);
		int sum = sumOfLeftLeavesIterative(root);
		System.out.println(sum);
	}

	private static int sumOfLeftLeaves(TreeNode root) {
		return sumOfLeft(root, false, 0);
	}

	private static int sumOfLeft(TreeNode root, boolean isLeft, int sum) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null && isLeft) {
			return root.val;
		}
		System.out.println(sum +" "+ root.val);
		return sum + sumOfLeft(root.left, true, sum) + sumOfLeft(root.right, false, sum);
	}
	
	private static int sumOfLeftLeavesIterative(TreeNode root) {
		Stack<TreeNode> stk = new Stack<TreeNode>();
		stk.push(root);
		int sum = 0;
		while(!stk.isEmpty()){
			TreeNode node = stk.pop();
			if(node.left!=null){
				if(node.left.left==null && node.left.right==null){
					sum = sum + node.left.val;
				}else{
					stk.push(node.left);
				}
			}
			if(node.right!=null && (node.right.left!=null || node.right.right!=null)){
				stk.push(node.right);
			}
		}
		return sum;
	}


}
