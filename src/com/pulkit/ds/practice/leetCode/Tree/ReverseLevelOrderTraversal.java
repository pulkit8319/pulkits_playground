package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

//Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

public class ReverseLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		/*root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);*/

		List<List<Integer>> list = levelOrderBottomRecursive(root);
		System.out.println(list.toString());
	}

	private static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> lst = new ArrayList();
		if (root == null) {
			return lst;
		}
		Stack<List<Integer>> stk = new Stack<List<Integer>>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> list = new ArrayList<Integer>();
			while (size > 0) {
				TreeNode node = q.poll();
				list.add(node.val);
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
				size--;
			}
			stk.add(list);
		}
		lst.addAll(stk);
		Collections.reverse(lst);
		return lst;
	}

	private static List<List<Integer>> levelOrderBottomRecursive(TreeNode root) {
		int h = height(root);
		List<List<Integer>> lst = new ArrayList<>();
		for (int i = 0; i < h; i++) {
			List<Integer> list = new ArrayList<>();
			lotRecursive(list,root, i);
			lst.add(list);
		}
		Collections.reverse(lst);
		return lst;
	}
	
	private static void lotRecursive(List<Integer> list, TreeNode root, int level) {
		if(root==null){
			return;
		}
		if(level==0){
			list.add(root.val);
		}else{
			lotRecursive(list,root.left,level-1);
			lotRecursive(list,root.right,level-1);
		}
		
	}

	private static int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(height(root.left), height(root.right)) + 1;
	}

}
