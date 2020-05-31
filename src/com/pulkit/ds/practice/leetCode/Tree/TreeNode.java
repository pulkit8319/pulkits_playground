package com.pulkit.ds.practice.leetCode.Tree;

public class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public void inOrder(TreeNode node){
		if(node==null)
		{
			return;
		}
		inOrder(node.left);
		System.out.print(node.val+" ");
		inOrder(node.right);
	}
	
	@Override
	public String toString() {
		return ""+this.val;
	}
}
