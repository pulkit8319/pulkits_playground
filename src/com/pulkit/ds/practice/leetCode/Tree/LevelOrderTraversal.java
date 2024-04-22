package com.pulkit.ds.practice.leetCode.Tree;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		levelOrderTraversalRecursive(root);
	}

	private static void levelOrderTraversalRecursive(TreeNode root) {
		int h = height(root);
		for(int i=0;i<h;i++){
			lot(root,i);
		}
	}

	private static void lot(TreeNode root, int level) {
		if(root==null){
			return;
		}
		if(level==0){
			System.out.print(root.val+" ");
		}else{
			lot(root.left,level-1);
			lot(root.right,level-1);
		}
		
	}

	private static int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(height(root.left), height(root.right) + 1);
	}

}
