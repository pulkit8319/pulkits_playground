package com.pulkit.ds.practice.leetCode.Tree;

import java.util.LinkedList;
import java.util.Queue;

//Given a binary tree, return the sum of values of its deepest leaves.
public class DeepestLeavesSum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(21);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(15);

		int sum = deepestLeavesSumIterative(root);
		System.out.println(sum);
	}

	private static int deepestLeavesSumIterative(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int sum=0;
		while(!q.isEmpty()){
			int size = q.size();
			sum = 0;
			while(size>0){
				TreeNode curr = q.poll();
				sum+=curr.val;
				if(curr.left!=null){
					q.add(curr.left);
				}
				if(curr.right!=null){
					q.add(curr.right);
				}
				size--;
			}
		}
		return sum;
	}

	static int sum = 0;

	private static int deepestLeavesSum(TreeNode root) {
		deepestLeavesSum(root, height(root));
		return sum;
	}

	private static void deepestLeavesSum(TreeNode root, int height) {
		if (root == null) {
			return;
		}
		if (height == 1) {
			sum += root.val;
		}
		deepestLeavesSum(root.left, height - 1);
		deepestLeavesSum(root.right, height - 1);
	}

	private static int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(height(root.left), height(root.right)) + 1;
	}

}
