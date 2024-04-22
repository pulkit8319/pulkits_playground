package com.pulkit.ds.practice.leetCode.Tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//Given an n-ary tree, return the preorder traversal of its nodes' values.
//Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

public class NAryPreOrderTraversal {

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
		List<Integer> list = preorderIterative(root);
		System.out.println(list);
	}

	private static List<Integer> preorderIterative(NAryNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root==null){
			return list;
		}
		Stack<NAryNode> stk = new Stack<NAryNode>();
		stk.add(root);
		while (!stk.isEmpty()) {
			NAryNode node = stk.pop();
			list.add(node.val);
			List<NAryNode> children = node.children;
			if(children!=null){
				for(int i = children.size()-1;i>=0;i--){
					stk.add(children.get(i));
				}
			}
		}
		return list;
	}

	static List<Integer> list = new ArrayList<Integer>();

	private static List<Integer> preorder(NAryNode root) {
		if (root == null) {
			return list;
		}
		list.add(root.val);
		List<NAryNode> children = root.children;
		if (children != null) {
			for (NAryNode node : children) {
				preorder(node);
			}
		}
		return list;
	}

}
