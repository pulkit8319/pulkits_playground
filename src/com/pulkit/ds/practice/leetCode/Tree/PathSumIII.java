package com.pulkit.ds.practice.leetCode.Tree;

//You are given a binary tree in which each node contains an integer value.
//Find the number of paths that sum to a given value.
//The path does not need to start or end at the root or a leaf,but it must go downwards(traveling only from parent nodes to child nodes).

public class PathSumIII {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(17);
		root.right.right = new TreeNode(7);
		int sum = 27;
		int totalPaths = pathSum(root,sum);
		System.out.println(totalPaths);
	}

	static int i = 0;
	private static int pathSum(TreeNode root, int sum) {
		if(root==null){
			return 0;
		}
		pathSumHelper(root,sum);
		pathSum(root.left, sum);
		pathSum(root.right, sum);
		return i;
	}
	private static void pathSumHelper(TreeNode root, int sum) {
		if(root==null){
			return;
		}
		int j = sum-root.val;
		if(j==0){
			i+=1;
		}
		pathSumHelper(root.left, j);
		pathSumHelper(root.right, j);
	}

}
