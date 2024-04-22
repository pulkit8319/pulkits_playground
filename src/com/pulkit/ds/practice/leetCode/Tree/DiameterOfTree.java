package com.pulkit.ds.practice.leetCode.Tree;

//Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
public class DiameterOfTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.right = new TreeNode(7);
		/*root.right.left = new TreeNode(1);
		root.right.left.left = new TreeNode(3);
		root.right.left.left.left = new TreeNode(9);
		root.right.left.left.right = new TreeNode(10);
		root.right.left.right = new TreeNode(6);
		root.right.right = new TreeNode(2);
		root.right.right.left = new TreeNode(8);
		root.right.right.left.right = new TreeNode(1);
		root.right.right.left.left = new TreeNode(2);
		root.right.right.right = new TreeNode(13);*/
		root.left = new TreeNode(4);
		int dia = diameterOfBinaryTree(root);
		System.out.println(dia);
	}
	
	static int maxDia = 0;
	private static int diameterOfBinaryTree(TreeNode root) {
		diameter(root);
		return maxDia;
		
	}
	private static int diameter(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = diameter(root.left);
		int right = diameter(root.right);
		if((left+right)>maxDia){
			maxDia = left+right;
		}
		return Math.max(left,right)+1;
	}

}
