package com.pulkit.ds.practice.leetCode.LinkedList;

public class LeetCodeDltGivenNode {
	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(9);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = null;
		ListNode node = head;
		deleteNode(node2);
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

	public static void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
