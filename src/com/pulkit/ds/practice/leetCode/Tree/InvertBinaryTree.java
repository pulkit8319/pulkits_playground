package com.pulkit.ds.practice.leetCode.Tree;

import java.util.LinkedList;
import java.util.Queue;

//Invert a binary tree.
public class InvertBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		TreeNode node = invertTree(root);
		node.inOrder(node);
	}

	private static TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		if(root.left==null && root.right==null){
			return root;
		}
		TreeNode temp = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(temp);
		return root;
	}
	
	private static TreeNode invertTreeIterative(TreeNode root) {
		if(root==null){
			return null;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while(!q.isEmpty()){
			TreeNode node = q.poll();
			TreeNode tmp = node.left;
			node.left = node.right;
			node.right = tmp;
			if(node.left!=null){
				q.offer(node.left);
			}
			if(node.right!=null){
				q.offer(node.right);
			}
		}
		return root;
	}

}
