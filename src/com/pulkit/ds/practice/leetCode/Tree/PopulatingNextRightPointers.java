package com.pulkit.ds.practice.leetCode.Tree;

import java.util.LinkedList;
import java.util.Queue;

import com.pulkit.ds.practice.leetCode.gfg.Tree.Node;

//You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
public class PopulatingNextRightPointers {

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(4);
		root.right = new Node(8);
		root.left.left = new Node(11);
		root.left.left.left = new Node(7);
		root.left.left.right = new Node(2);
		root.right.left = new Node(13);
		root.right.right = new Node(4);
		root.right.right.right = new Node(1);
		Node node = connectContantSpace(root);
		node.inorder(node);
	}

	private static Node connectContantSpace(Node root) {
		if(root==null){
			return null;
		}
		Node node = root,tmp;
		while(node.left!=null){
			tmp = node;
			while(tmp!=null){
				if(tmp.left!=null){
					tmp.left.next = tmp.right;
				}
				if(tmp.next!=null){
					tmp.right.next = tmp.next.left;
				}
				tmp = tmp.next;
			}
			node = node.left;
		}
		return root;
	}

	private static Node connectContantSpace1(Node root) {
		if (root == null) {
			return null;
		}
		Node tmp, node = root;
		while (node.left != null) {
			tmp = node;
			while (tmp != null) {
				tmp.left.next = tmp.right;
				if (tmp.next != null) {
					tmp.right.next = tmp.next.left;
				}
				tmp = tmp.next;
			}
			node = node.left;
		}
		return root;
	}

	private static Node connect(Node root) {
		if (root == null) {
			return root;
		}
		Node node = root;
		Queue<Node> q = new LinkedList<>();
		q.offer(node);
		while (!q.isEmpty()) {
			int size = q.size();
			while (size > 0) {
				Node curr = q.poll();
				if (size == 1) {
					curr.next = null;
				} else {
					curr.next = q.peek();
				}
				size--;
				if (curr.left != null) {
					q.offer(curr.left);
				}
				if (curr.right != null) {
					q.offer(curr.right);
				}
			}
		}
		return root;
	}

}
