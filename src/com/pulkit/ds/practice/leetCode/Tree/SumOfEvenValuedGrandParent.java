package com.pulkit.ds.practice.leetCode.Tree;

//Given a binary tree, return the sum of values of nodes with even-valued grandparent.  (A grandparent of a node is the parent of its parent, if it exists.)
//If there are no nodes with an even-valued grandparent, return 0.

public class SumOfEvenValuedGrandParent {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(9);
		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(22);
		int sum = sumEvenGrandparentOptimized(root);
		System.out.println(sum);
	}

	private static int sumEvenGrandparentOptimized(TreeNode root) {
		if(root!=null){
			sumEvenGrandparentOptimized(root,root.left);
			sumEvenGrandparentOptimized(root,root.right);
		}
		return sum;
	}

	private static void sumEvenGrandparentOptimized(TreeNode root, TreeNode grandParent) {
		if(root==null || grandParent==null){
			return;
		}
		if(root.val%2==0){
			if(grandParent.left!=null){
				sum+=grandParent.left.val;
			}
			if(grandParent.right!=null){
				sum+=grandParent.right.val;
			}
		}
		sumEvenGrandparentOptimized(grandParent,grandParent.left);
		sumEvenGrandparentOptimized(grandParent,grandParent.right);
	}

	static int sum = 0;

	private static int sumEvenGrandparent(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.val % 2 == 0) {
			if (root.left != null) {
				if (root.left.left != null) {
					sum += root.left.left.val;
				}
				if (root.left.right != null) {   
					sum += root.left.right.val;
				}
			}
			if (root.right != null) {
				if (root.right.left != null) {
					sum += root.right.left.val;
				}
				if (root.right.right != null) {
					sum += root.right.right.val;
				}
			}
		}
		sumEvenGrandparent(root.left);
		sumEvenGrandparent(root.right);
		return sum;
	}

}
