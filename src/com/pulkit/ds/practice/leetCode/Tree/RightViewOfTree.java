package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

public class RightViewOfTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(5);
		List<Integer> list = rightSideView(root);
		System.out.println(list);
	}

	private static List<Integer> rightSideViewIterative(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if(root==null){
			return list;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			int size = q.size();
			while(size>0){
				TreeNode curr = q.poll();
				if(size==1){
					list.add(curr.val);
				}
				if(curr.left!=null){
					q.add(curr.left);
				}
				if(curr.right!=null){
					q.add(curr.right);
				}
				size--;
			}
		}
		return list;
	}

	static List<Integer> list = new ArrayList<>();
	static int maxLevel = 0;
	private static List<Integer> rightSideView(TreeNode root) {
		rightSideView(root, 1);
		return list;
	}

	private static void rightSideView(TreeNode root, int level) {
		if (root == null) {
			return;
		}
		if(maxLevel<level){
			list.add(root.val);
			maxLevel = level;
		}
		rightSideView(root.right,level+1);
		rightSideView(root.left,level+1);
	}

}
