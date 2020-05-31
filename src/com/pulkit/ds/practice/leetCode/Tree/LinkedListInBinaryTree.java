package com.pulkit.ds.practice.leetCode.Tree;

//Given a binary tree root and a linked list with head as the first node. 
//Return True if all the elements in the linked list starting from the head correspond to some downward path connected in the binary tree otherwise return False.
//In this context downward path means a path that starts at some node and goes downwards.

public class LinkedListInBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(4);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(2);
		root.right.left.left = new TreeNode(6);
		root.right.left.right = new TreeNode(8);

		ListNode head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next = new ListNode(8);
		boolean isSubPath = isSubPath(head, root);
		System.out.println(isSubPath);
	}

	private static boolean isSubPath(ListNode head, TreeNode root) {
		if (root == null) {
			return false;
		}
		return check(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
	}

	private static boolean check(ListNode head, TreeNode root) {
		if (head == null) {
			return true;
		}
		if (root == null) {
			return false;
		}
		if (root.val != head.val) {
			return false;
		}
		return check(head.next, root.left) || check(head.next, root.right);
	}

}
