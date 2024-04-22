package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//Given an n-ary tree, return the postorder traversal of its nodes' values.
//Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
public class NAryPostOrderTraversal {

	public static void main(String[] args) {
		NAryNode root = new NAryNode(1);
		NAryNode node1 = new NAryNode(3);
		NAryNode node2 = new NAryNode(2);
		NAryNode node3 = new NAryNode(4);
		NAryNode node4 = new NAryNode(5);
		NAryNode node5 = new NAryNode(6);
		List<NAryNode> list1 = new ArrayList<>();
		list1.add(node1);
		list1.add(node2);
		list1.add(node3);
		root.children = list1;
		List<NAryNode> list2 = new ArrayList<>();
		list2.add(node4);
		list2.add(node5);
		node1.children = list2;
		List<Integer> list = postorderIterative(root);
		System.out.println(list);
	}
	
	private static List<Integer> postorderIterative(NAryNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root==null){
			return list;
		}
		Stack<NAryNode> stk = new Stack<>();
		stk.add(root);
		while(!stk.isEmpty()){
			root = stk.pop();
			list.add(root.val);
			 for(NAryNode node: root.children){
				 stk.add(node);
			 }
		}
		Collections.reverse(list);
		return list;
	}

	static List<Integer> list = new ArrayList<Integer>();

	private static List<Integer> postorder(NAryNode root) {
		if(root==null){
			return list;
		}
		List<NAryNode> children = root.children;
		if(children!=null){
			for(NAryNode node:children){
				postorder(node);
			}
		}
		list.add(root.val);
		return list;
	}
	
}
