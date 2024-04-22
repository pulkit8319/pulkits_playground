package com.pulkit.ds.practice.leetCode.Tree;

import java.util.LinkedList;
import java.util.Queue;

//A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.
//Write a data structure CBTInserter that is initialized with a complete binary tree and supports the following operations:
//CBTInserter(TreeNode root) initializes the data structure on a given tree with head node root;
//CBTInserter.insert(int v) will insert a TreeNode into the tree with value node.val = v so that the tree remains complete, and returns the value of the parent of the inserted TreeNode;
//CBTInserter.get_root() will return the head node of the tree.
public class CBTInserter {

	TreeNode root;
	Queue<TreeNode> q;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(17);
		root.right.right = new TreeNode(7);
		CBTInserter cb = new CBTInserter(root);
		System.out.println(cb.insert(10));
		System.out.println(cb.get_root());

	}

	public CBTInserter(TreeNode root) {
		this.root = root;
		q = new LinkedList<>();
		populate(q, root);
	}

	private void populate(Queue<TreeNode> q, TreeNode root) {
		if (root != null) {
			q.add(root);
			while (true) {
					TreeNode curr = q.peek();
					if (curr.left != null) {
						q.add(curr.left);
					}
					if (curr.right != null) {
						q.add(curr.right);
					}
					if (curr.left == null || curr.right == null) {
						break;
					}
					q.poll();
				}
			}
	}

	public int insert(int v) {
		TreeNode node = new TreeNode(v);
		TreeNode curr = q.peek();
		if (curr.left == null) {
			curr.left = node;
		} else {
			curr.right = node;
			q.poll();
		}
		q.add(node);
		return curr.val;
	}

	public TreeNode get_root() {
		return this.root;
	}

}
