package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		List<Integer> list = postorderTraversalIterative(root);
		System.out.println(list);
	}
	
	private static List<Integer> postorderTraversalIterative(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if(root==null){
			return list;
		}
		Stack<TreeNode> stk = new Stack<>();
		stk.add(root);
		while(!stk.isEmpty()){
			TreeNode curr = stk.pop();
			list.add(curr.val);
			if(curr.left!=null){
				stk.add(curr.left);
			}
			if(curr.right!=null){
				stk.add(curr.right);
			}
		}
		Collections.reverse(list);
		return list;
	}

	private static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root!=null){
			postorderTraversal(root,list);
		}
		return list;
	}

	private static void postorderTraversal(TreeNode root, List<Integer> list) {
		if(root==null){
			return;
		}
		postorderTraversal(root.left,list);
		postorderTraversal(root.right,list);
		list.add(root.val);
	}

}
