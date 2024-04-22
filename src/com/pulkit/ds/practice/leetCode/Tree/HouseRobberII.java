package com.pulkit.ds.practice.leetCode.Tree;

//The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
//Determine the maximum amount of money the thief can rob tonight without alerting the police.

//Use DP
public class HouseRobberII {

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

		int money = rob(root);
		System.out.println(money);
	}

	static int sumOdd,sumEven;
	private static int rob(TreeNode root) {
		rob(root,0);
		return sumOdd>sumEven?sumOdd:sumEven;
	}
	private static void rob(TreeNode root, int level) {
		if(root==null){
			return;
		}
		if(level%2==0){
			sumEven+=root.val;
		}else{
			sumOdd+=root.val;
		}
		rob(root.left,level+1);
		rob(root.right,level+1);
	}

}
