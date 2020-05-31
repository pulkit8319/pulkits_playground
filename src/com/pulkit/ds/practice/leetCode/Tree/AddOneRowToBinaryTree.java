package com.pulkit.ds.practice.leetCode.Tree;

import java.util.LinkedList;
import java.util.Queue;

//Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.
//The adding rule is:given a positive integer depth d,for each NOT null tree nodes N in depth d-1,create two tree nodes with value v as N'sleft subtree root and right subtree root.And N'soriginal left subtree should be the left subtree of the new left subtree root,its original right subtree should be the right subtree of the new right subtree root.If depth d is 1 that means there is no depth d-1 at all,then create a tree node with value v as the new root of the whole original tree,and the original tree is the new root'sleft subtree.

public class AddOneRowToBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);
		root.right.left = new TreeNode(5);
		int v = 1, d = 2;
		TreeNode node = addOneRowIterative(root, v, d);
		node.inOrder(node);
	}

	private static TreeNode addOneRowIterative(TreeNode root, int v, int d) {
		if (d == 1) {
			TreeNode node = new TreeNode(v);
			node.left = root;
			return node;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(d!=2){
			int size = q.size();
			while(size>0){
				TreeNode curr = q.poll();
				if(curr.left!=null){
					q.add(curr.left);
				}
				if(curr.right!=null){
					q.add(curr.right);
				}
				size--;
			}
			d--;
		}
		while(!q.isEmpty()){
			TreeNode curr = q.poll();
			TreeNode node = curr.left;
			curr.left = new TreeNode(v);
			curr.left.left = node;
			node = curr.right;
			curr.right = new TreeNode(v);
			curr.right.right = node;
		}
		return root;
	}

	private static TreeNode addOneRow(TreeNode root, int v, int d) {
		if (d == 1) {
			TreeNode node = new TreeNode(v);
			node.left = root;
			return node;
		}
		return addOneRowAlternate(root, v, d);
	}

	private static TreeNode addOneRowAlternate(TreeNode root, int v, int d) {
		if(root==null){
			return null;
		}
		if(d==2){
			TreeNode left = root.left;
			root.left = new TreeNode(v);
			root.left.left = left;
			TreeNode right = root.right;
			root.right = new TreeNode(v);
			root.right.right = right;
		}
		addOneRow(root.left, v, d-1);
		addOneRow(root.right, v, d-1);
		return root;
	}

	private static TreeNode addOneRow(TreeNode root, int v, int d, boolean isLeft) {
		if (root == null) {
			if(d==1){
				return new TreeNode(v);
			}else{
				return null;
			}
		}
		if (d == 1) {
			TreeNode node = new TreeNode(v);
			if (isLeft) {
				node.left = root;
			} else {
				node.right = root;
			}
			return node;
		}
		root.left = addOneRow(root.left, v, d-1, true);
		//System.out.println(root.val);
		root.right = addOneRow(root.right, v, d-1, false);
		return root;
	}

}
