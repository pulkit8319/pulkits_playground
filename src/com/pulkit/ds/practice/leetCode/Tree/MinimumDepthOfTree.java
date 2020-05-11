package com.pulkit.ds.practice.leetCode.Tree;

import java.util.LinkedList;
import java.util.Queue;

//Given a binary tree, find its minimum depth.
//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
public class MinimumDepthOfTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
	//	root.left.right = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(17);
		root.right.right = new TreeNode(7);
		/*
		 * TreeNode root = new TreeNode(3); root.left = new TreeNode(9);
		 */
		int minDepth = minDepthIterative(root);
		System.out.println(minDepth);
	}

	private static int minDepth(TreeNode root) {
		if(root==null){
			return 0;
		}
		if(root.left == null && root.right==null){
			return 1;
		}
		if(root.left==null){
			return minDepth(root.right)+1;
		}
		if(root.right==null){
			return minDepth(root.left)+1;
		}
		return Math.min(minDepth(root.left),minDepth(root.right))+1;
	}
	
	private static int minDepthIterative(TreeNode root){
		if(root==null){
			return 0;
		}
		int level = 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while(!q.isEmpty()){
			int size = q.size();
			level++;
			while(size>0){
				TreeNode node = q.poll();
				if(node.left==null && node.right==null){
					return level;
				}
				if(node.left!=null){
					q.offer(node.left);
				}
				if(node.right!=null){
					q.offer(node.right);
				}
				size--;
			}
		}
		return level;
	}

}
