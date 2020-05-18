package com.pulkit.ds.practice.leetCode.Tree;

//A binary tree is univalued if every node in the tree has the same value.
//Return true if and only if the given tree is univalued.
public class UnivaluedBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(1);
		boolean isUnival = isUnivalTree(root);
		System.out.println(isUnival);
	}

	static Integer prev;
	private static boolean isUnivalTree(TreeNode root) {
		if(root==null){
			return true;
		}
		if(null!=prev){
			if(!prev.equals(root.val)){
				return false;
			}
		}
		prev = root.val;
		return isUnivalTree(root.left) && isUnivalTree(root.right);
	}

}
